package com.looboo.kafkasql.assemble;

import com.looboo.kafkasql.kafka.KafkaUtil;
import com.looboo.kafkasql.parser.KafkaSqlParser;
import org.antlr.v4.runtime.tree.ParseTree;

public class OffsetStatementProcessor implements Processor {

    public OffsetStatementProcessor(KafkaUtil util) {

    }

    @Override
    public void process(ParseTree tree) {
        if (!(tree instanceof KafkaSqlParser.OffsetStatementContext)) {
            return;
        }


    }
}
