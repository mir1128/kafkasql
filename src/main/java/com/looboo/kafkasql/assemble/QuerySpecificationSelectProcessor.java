package com.looboo.kafkasql.assemble;

import com.looboo.kafkasql.assemble.filter.EqualFilter;
import com.looboo.kafkasql.assemble.filter.Filter;
import com.looboo.kafkasql.assemble.filter.InFilter;
import com.looboo.kafkasql.assemble.filter.PartitionCompose;
import com.looboo.kafkasql.kafka.KafkaUtil;
import com.looboo.kafkasql.parser.KafkaSqlParser;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.looboo.kafkasql.assemble.Constant.FROM;
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
    public void process(ParseTree tree) {
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

        selectMessages(topicName, offset, equalFilters);
    }

    private List<Filter> generateFilters(ParseTree tree) {
        if (tree.getChildCount() < 3) {
            return new ArrayList<>();
        }

        ParseTree whereClause = tree.getChild(3);

        if (whereClause.getChildCount() < 2 || !whereClause.getChild(0).getText().equals(WHERE)) {
            log.warn("not a valid where clause");
        }

        ParseTree whereClauseContent = whereClause.getChild(1);
        if (whereClauseContent instanceof KafkaSqlParser.EquationClauseContext) {

        } else if (whereClauseContent instanceof KafkaSqlParser.InCluaseContext) {
            String variable = whereClauseContent.getChild(0).getText();
            List<String> parameters = new ArrayList<>();
            for (int i = 3; i < whereClauseContent.getChildCount(); i += 2) {
                parameters.add(whereClauseContent.getChild(i).getText());
            }
            return Arrays.asList(new InFilter(parameters, variable, null));
        } else {

        }
        return null;
    }

    private String selectMessages(String topicName, Map<TopicPartition, Long> offset, List<Filter> filters) {

        List<Filter> partitionFilters = filters.stream().filter(f -> f.isPartition()).collect(Collectors.toList());

        Map<TopicPartition, Long> offsetReserved = offset.entrySet().stream()
                .filter(e -> new PartitionCompose(partitionFilters).predicate(e.getKey().partition()))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

        Map<TopicPartition, List<ConsumerRecord>> result = kafkaUtil.poll(topicName, offsetReserved);

        String resultString = formatResult(result);
        return resultString;
    }

    private String formatResult(Map<TopicPartition, List<ConsumerRecord>> result) {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------------------------------\n");
        for (TopicPartition topicPartition : result.keySet()) {
            sb.append("topic: " + topicPartition.topic() + "\tpartition: " + topicPartition.partition() + "\n");
            List<ConsumerRecord> records = result.get(topicPartition);
            for (ConsumerRecord record : records) {
                sb.append("key : " + new String((byte[]) record.key()) + "\tvalue: " + new String((byte[]) record.value())).append("\n");
            }
            sb.append("-------------------------------------------\n");
        }

        System.out.println(sb.toString());
        return sb.toString();
    }
}
