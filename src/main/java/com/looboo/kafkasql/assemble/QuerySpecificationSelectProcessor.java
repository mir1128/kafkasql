package com.looboo.kafkasql.assemble;

import com.looboo.kafkasql.kafka.KafkaUtil;
import com.looboo.kafkasql.parser.KafkaSqlLexer;
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

@Slf4j
public class QuerySpecificationSelectProcessor implements SelectProcessor {

    private final String STAR = KafkaSqlLexer.VOCABULARY.getSymbolicName(KafkaSqlLexer.STAR);
    private final String FROM = KafkaSqlLexer.VOCABULARY.getSymbolicName(KafkaSqlLexer.FROM);
    private final String WHERE = KafkaSqlLexer.VOCABULARY.getSymbolicName(KafkaSqlLexer.WHERE);
    private final String PARTITION = KafkaSqlLexer.VOCABULARY.getSymbolicName(KafkaSqlLexer.PARTITION);
    private final String TIMESTAMP = KafkaSqlLexer.VOCABULARY.getSymbolicName(KafkaSqlLexer.TIMESTAMP);

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

        List<Filter> filters = generateFilter(tree);

        selectAllMessages(topicName, offset, filters);
    }

    private List<Filter> generateFilter(ParseTree tree) {
        if (tree.getChildCount() < 4) {
            return new ArrayList<>();
        }

        ParseTree whereClause = tree.getChild(3);

        if (whereClause.getChildCount() < 2 || !whereClause.getChild(0).getText().equals(WHERE)) {
            return new ArrayList<>();
        }

        ParseTree whereClauseContent = whereClause.getChild(1);
        if (whereClauseContent instanceof KafkaSqlParser.EquationClauseContext) {
            if (whereClauseContent.getChildCount() == 0) {
                return new ArrayList<>();
            }

            ParseTree equationClause = whereClauseContent.getChild(0);
            if (equationClause.getChildCount() != 3) {
                return new ArrayList<>();
            }

            if (equationClause.getChild(0).getText().equals(PARTITION)) {
                Integer partition = Integer.valueOf(equationClause.getChild(2).getText());
                return Arrays.asList(i -> i.equals(partition));

            } else if (equationClause.getChild(0).getText().equals(TIMESTAMP)) {
                Integer timestamp = Integer.valueOf(equationClause.getChild(2).getText());
                return Arrays.asList(i -> i.equals(timestamp));
            } else {
                return new ArrayList<>();
            }
        }

        return new ArrayList<>();
    }

    private String selectAllMessages(String topicName, Map<TopicPartition, Long> offset, List<Filter> filters) {

        Map<TopicPartition, Long> offsetReserved = offset.entrySet().stream()
                .filter(e -> new PartitionCompose(filters).predicate(e.getKey().partition()))
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
