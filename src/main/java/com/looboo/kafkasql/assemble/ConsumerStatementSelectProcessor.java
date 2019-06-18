package com.looboo.kafkasql.assemble;

import com.looboo.kafkasql.kafka.KafkaUtil;
import com.looboo.kafkasql.parser.KafkaSqlParser;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.kafka.clients.admin.ConsumerGroupDescription;

import java.util.Arrays;
import java.util.Map;

import static com.looboo.kafkasql.assemble.Constant.CONSUMERS;
import static com.looboo.kafkasql.assemble.Constant.STAR;


@Slf4j
public class ConsumerStatementSelectProcessor implements SelectProcessor {

    private KafkaUtil kafkaUtil;

    public ConsumerStatementSelectProcessor(KafkaUtil util) {
        kafkaUtil = util;
    }

    @Override
    public String process(ParseTree tree) {
        if (!(tree instanceof KafkaSqlParser.ConsumersStatementContext)) {
            return "";
        }

        String groupKeyword = tree.getChild(0).getText();
        if (!groupKeyword.equalsIgnoreCase(CONSUMERS)) {
            log.warn("not a valid consumers clause {}", tree.getText());
            return "";
        }

        String groupName = tree.getChild(2).getText();
        if (groupName.equalsIgnoreCase(STAR)) {
            return formatResult(kafkaUtil.listConsumerGroups());
        } else {
            return formatResult(kafkaUtil.listConsumerGroups(Arrays.asList(groupName)));
        }
    }

    private String formatResult(Map<String, ConsumerGroupDescription> consumerGroupMapping) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, ConsumerGroupDescription> entry : consumerGroupMapping.entrySet()) {
            stringBuilder.append("group id: ").append(entry.getKey()).append("\t")
                .append("description: ").append(entry.getValue().toString()).append("\n");
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }
}
