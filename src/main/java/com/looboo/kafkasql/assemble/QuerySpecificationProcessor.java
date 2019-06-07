package com.looboo.kafkasql.assemble;

import com.looboo.kafkasql.kafka.KafkaUtil;
import com.looboo.kafkasql.parser.KafkaSqlLexer;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;

import java.util.List;
import java.util.Map;

@Slf4j
public class QuerySpecificationProcessor implements Processor {

    private final String STAR = KafkaSqlLexer.VOCABULARY.getSymbolicName(KafkaSqlLexer.STAR);
    private final String FROM = KafkaSqlLexer.VOCABULARY.getSymbolicName(KafkaSqlLexer.FROM);

    private String selectContent;
    private String topicName;

    private KafkaUtil kafkaUtil;

    public QuerySpecificationProcessor(KafkaUtil kafkaUtil) {
        this.kafkaUtil = kafkaUtil;
    }

    @Override
    public void process(ParseTree tree) {
        if (!tree.getChild(1).getText().equals(FROM)) {
            log.warn("not a valid query statement: {}", tree.getText());
        }
        selectContent = tree.getChild(0).getText();
        topicName = tree.getChild(2).getText();

        log.info("[Query Specification Processor] query topic is {}, select content is {}", topicName, selectContent);

        String topic = kafkaUtil.listTopics().stream()
                .filter(t -> t.equalsIgnoreCase(topicName))
                .findFirst()
                .orElse(null);

        if (topic == null) {
            log.warn("topic {} is not exist", topicName);
        }

        Map<TopicPartition, Long> offset = kafkaUtil.getOffset(topic);

        selectAllMessages(topicName, offset);
    }

    private String selectAllMessages(String topicName, Map<TopicPartition, Long> offset) {
        Map<TopicPartition, List<ConsumerRecord>> result = kafkaUtil.poll(topicName, offset);
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
