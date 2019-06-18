package com.looboo.kafkasql.assemble;

import com.looboo.kafkasql.kafka.KafkaUtil;
import com.looboo.kafkasql.parser.KafkaSqlParser;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.tree.ParseTree;

import static com.looboo.kafkasql.assemble.Constant.OFFSETS;
import static com.looboo.kafkasql.assemble.Constant.TOPICS;

@Slf4j
public class TopicStatementSelectProcessor implements SelectProcessor {

    private KafkaUtil kafkaUtil;

    public TopicStatementSelectProcessor(KafkaUtil util) {
        this.kafkaUtil = util;
    }

    @Override
    public String process(ParseTree tree) {
        if (!(tree instanceof KafkaSqlParser.TopicStatementContext)) {
            return "";
        }

        if (!tree.getChild(0).getText().equalsIgnoreCase(TOPICS)) {
            log.warn("statement does not contents topics {}", tree.getText());
        }

        StringBuilder stringBuilder = new StringBuilder();
        kafkaUtil.listTopics().forEach(topic -> stringBuilder.append("topic: " + topic).append("\n"));
        log.info(stringBuilder.toString());
        return stringBuilder.toString();
    }
}

