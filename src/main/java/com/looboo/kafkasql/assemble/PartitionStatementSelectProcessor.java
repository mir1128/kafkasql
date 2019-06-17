package com.looboo.kafkasql.assemble;

import com.looboo.kafkasql.kafka.KafkaUtil;
import com.looboo.kafkasql.parser.KafkaSqlParser;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Collection;

import static com.looboo.kafkasql.assemble.Constant.PARTITIONS;


//select partitions(topic);
@Slf4j
public class PartitionStatementSelectProcessor implements SelectProcessor {

    private KafkaUtil kafkaUtil;

    public PartitionStatementSelectProcessor(KafkaUtil util) {
        kafkaUtil = util;
    }

    @Override
    public String process(ParseTree tree) {
        if (!(tree instanceof KafkaSqlParser.PartitionsStatementContext)) {
            return "";
        }

        String partitionsKeyword = tree.getChild(0).getText();
        if (!partitionsKeyword.equalsIgnoreCase(PARTITIONS)) {
            log.warn("not a valid partitions clause {}", tree.getText());
            return "";
        }

        String topicName = tree.getChild(2).getText();
        String topic = kafkaUtil.listTopics().stream()
                .filter(t -> t.equalsIgnoreCase(topicName))
                .findFirst()
                .orElse(null);

        Collection<Integer> partitions = kafkaUtil.listPartitions(topic);

        String s = formatResult(partitions, topic);
        return s;
    }

    private String formatResult(Collection<Integer> partitions, String topic) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("topic ").append(topic).append(" has partitions: \n");
        for (Integer partition: partitions) {
            stringBuilder.append(partition).append("\n");
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }
}
