package com.looboo.kafkasql.assemble;

import com.looboo.kafkasql.assemble.filter.BetweenFilter;
import com.looboo.kafkasql.assemble.filter.EqualFilter;
import com.looboo.kafkasql.assemble.filter.Filter;
import com.looboo.kafkasql.assemble.filter.InFilter;
import com.looboo.kafkasql.assemble.filter.PartitionCompose;
import com.looboo.kafkasql.kafka.KafkaUtil;
import com.looboo.kafkasql.parser.KafkaSqlParser;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.looboo.kafkasql.assemble.Constant.FROM;
import static com.looboo.kafkasql.assemble.Constant.PARTITION;
import static com.looboo.kafkasql.assemble.Constant.TIMESTAMP;
import static com.looboo.kafkasql.assemble.Constant.WHERE;

@Slf4j
public class QuerySpecificationSelectProcessor implements SelectProcessor {

    private String selectContent;
    private String topicName;

    private KafkaUtil kafkaUtil;

    public QuerySpecificationSelectProcessor(KafkaUtil kafkaUtil) {
        this.kafkaUtil = kafkaUtil;
    }

    @Override
    public String process(ParseTree tree) {
        if (!tree.getChild(1).getText().equals(FROM)) {
            log.warn("not a valid query statement: {}", tree.getText());
        }
        selectContent = tree.getChild(0).getText();
        topicName = tree.getChild(2).getText();

        log.info("[Query Specification SelectProcessor] query topic is {}, select content is {}", topicName, selectContent);

        String topic = kafkaUtil.listTopics().stream()
                .filter(t -> t.equalsIgnoreCase(topicName))
                .findFirst()
                .orElse(null);

        if (topic == null) {
            log.warn("topic {} is not exist", topicName);
        }

        Map<TopicPartition, Long> offset = kafkaUtil.getOffset(topic);
        List<Filter> equalFilters = generateFilters(tree);

        return selectMessages(topicName, offset, equalFilters);
    }

    private List<Filter> generateFilters(ParseTree tree) {
        if (tree.getChildCount() < 4) {
            return new ArrayList<>();
        }

        ParseTree whereClause = tree.getChild(3);

        if (whereClause.getChildCount() < 2 || !whereClause.getChild(0).getText().equals(WHERE)) {
            log.warn("not a valid where clause");
        }

        List<Filter> filters = new ArrayList<>();
        ParseTree whereClauseContent = whereClause.getChild(1);
        if (whereClauseContent instanceof KafkaSqlParser.EquationClauseContext) {
            filters = equationCluse(whereClauseContent);
        } else if (whereClauseContent instanceof KafkaSqlParser.InCluaseContext) {
            filters = inClause(whereClauseContent);
        } else if (whereClauseContent instanceof KafkaSqlParser.BetweenCluaseContext) {
            filters = betweenClause(whereClauseContent);
        } else {

        }
        return filters;
    }

    private List<Filter> betweenClause(ParseTree whereClauseContent) {
        List<Filter> filters = new ArrayList<>();
        String variable = whereClauseContent.getChild(0).getText();
        String from = whereClauseContent.getChild(3).getText();
        String to = whereClauseContent.getChild(5).getText();

        filters.add(new BetweenFilter(new Pair<String, String>(from, to), variable, null));
        return filters;
    }

    private List<Filter> inClause(ParseTree whereClauseContent) {
        List<Filter> filters = new ArrayList<>();

        ParseTree tree = whereClauseContent.getChild(0);

        if (tree instanceof TerminalNode) {
            String variable = tree.getText();
            List<String> parameters = new ArrayList<>();
            for (int i = 3; i < whereClauseContent.getChildCount(); i += 2) {
                parameters.add(whereClauseContent.getChild(i).getText());
            }
            filters.add(new InFilter(parameters, variable, null));
        } else if (tree instanceof KafkaSqlParser.ValueContext) {
            String function = tree.getChild(0).getChild(0).getText();
            String field = tree.getChild(0).getChild(2).getText();
            List<String> parameters = new ArrayList<>();
            for (int i = 3; i < whereClauseContent.getChildCount(); i += 2) {
                parameters.add(whereClauseContent.getChild(i).getText());
            }
            filters.add(new InFilter(parameters, field, function));
        } else {
            log.warn("unsupported node {}", tree.getText());
        }

        return filters;
    }

    private List<Filter> equationCluse(ParseTree whereClauseContent) {
        List<Filter> filters = new ArrayList<>();
        ParseTree equationClauseTree = whereClauseContent.getChild(0);

        if (equationClauseTree instanceof KafkaSqlParser.PartitionsEquslCluaseContext) {
            String variable = equationClauseTree.getChild(2).getText();
            filters.add(new EqualFilter(variable, PARTITION, null));
        } else if (equationClauseTree instanceof KafkaSqlParser.TimestampEquslCluaseContext) {
            String variable = equationClauseTree.getChild(2).getText();
            filters.add(new EqualFilter(variable, TIMESTAMP, null));
        } else if (equationClauseTree instanceof KafkaSqlParser.ValueEqualClauseContext) {
            ParseTree valueContext = equationClauseTree.getChild(0);
            if (valueContext instanceof KafkaSqlParser.ValueContext) {
                ParseTree valueFunction = valueContext.getChild(0);
                String function = valueFunction.getChild(0).getText();
                String parameter = valueFunction.getChild(2).getText();
                String value = equationClauseTree.getChild(2).getText();
                filters.add(new EqualFilter(value, parameter, function));
            }
        } else {
            log.warn("{} is not a valid equation clause", equationClauseTree.getText());
        }
        return filters;
    }

    private String selectMessages(String topicName, Map<TopicPartition, Long> offset, List<Filter> filters) {

        List<Filter> partitionFilters = filters.stream().filter(f -> f.isPartition()).collect(Collectors.toList());

        Map<TopicPartition, Long> offsetReserved = offset.entrySet().stream()
                .filter(e -> new PartitionCompose(partitionFilters).predicate(e.getKey().partition()))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        Map<TopicPartition, List<ConsumerRecord>> result = kafkaUtil.poll(topicName, offsetReserved);

        result = filterResults(result, filters);

        String resultString = formatResult(result);
        return resultString;
    }

    private Map<TopicPartition, List<ConsumerRecord>> filterResults(Map<TopicPartition, List<ConsumerRecord>> result, List<Filter> filters) {
        List<Filter> filtersExcludePartition = filters.stream().filter(f -> !f.isPartition()).collect(Collectors.toList());

        for (Map.Entry<TopicPartition, List<ConsumerRecord>> recordEntity : result.entrySet()) {
            List<ConsumerRecord> filtered = recordEntity.getValue().stream()
                    .filter(record -> new PartitionCompose(filtersExcludePartition).predicate(record))
                    .collect(Collectors.toList());
            result.put(recordEntity.getKey(), filtered);
        }
        return result;
    }

    private String formatResult(Map<TopicPartition, List<ConsumerRecord>> result) {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------------------------------\n");
        for (TopicPartition topicPartition : result.keySet()) {
            sb.append("topic: " + topicPartition.topic() + "\t\tpartition: " + topicPartition.partition() + "\t\t\t\ttimestamp\n");
            List<ConsumerRecord> records = result.get(topicPartition);
            for (ConsumerRecord record : records) {
                sb.append("key : " + new String((byte[]) record.key()))
                        .append("\t\t\t\tvalue: " + new String((byte[]) record.value()))
                        .append("\t\t\t\ttimestamp: " + record.timestamp())
                        .append("\n");
            }
            sb.append("-------------------------------------------\n");
        }

        System.out.println(sb.toString());
        return sb.toString();
    }
}
