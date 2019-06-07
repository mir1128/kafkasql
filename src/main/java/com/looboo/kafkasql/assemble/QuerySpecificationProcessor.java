package com.looboo.kafkasql.assemble;

import com.looboo.kafkasql.kafka.KafkaUtil;
import com.looboo.kafkasql.parser.KafkaSqlLexer;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.tree.ParseTree;

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
        if (!tree.getChild(1).equals(FROM)) {
//            log.warn("not a valid query statement: {}", tree.getText());
        }
        selectContent = tree.getChild(0).getText();
        topicName = tree.getChild(2).getText();

        if (!kafkaUtil.listTopics().contains(topicName)) {
            log.warn("topic {} is not exist", topicName);
        }
    }
}
