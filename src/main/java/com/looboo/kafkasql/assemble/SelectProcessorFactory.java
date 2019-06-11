package com.looboo.kafkasql.assemble;

import com.looboo.kafkasql.kafka.KafkaUtil;
import com.looboo.kafkasql.parser.KafkaSqlParser;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.tree.ParseTree;

/*
SELECT topicStatement
    | SELECT offsetStatement
    | SELECT partitionsStatement
    | SELECT consumersStatement
    | SELECT consumerOffsetStatement
    | SELECT querySpecification
    ;
 */

@Slf4j
public class SelectProcessorFactory {

    public static SelectProcessor createProcessor(ParseTree tree, KafkaUtil util) {
        if (tree instanceof KafkaSqlParser.OffsetStatementContext) {
            return new OffsetStatementSelectProcessor(util);
        } else if (tree instanceof KafkaSqlParser.QuerySpecificationContext) {
            return new QuerySpecificationSelectProcessor(util);
        } else if (tree instanceof KafkaSqlParser.TopicStatementContext) {
            return new TopicStatementSelectProcessor(util);
        } else if (tree instanceof KafkaSqlParser.PartitionsStatementContext) {
            return new PartitionStatementSelectProcessor(util);
        } else if (tree instanceof KafkaSqlParser.ConsumersStatementContext) {
            return new ConsumerStatementSelectProcessor(util);
        } else if (tree instanceof KafkaSqlParser.ConsumerOffsetStatementContext) {
            return new ConsumerOffsetStatementSelectProcessor(util);
        } else {
//            log.error("[error] not a valid statement");
            return null;
        }
    }
}
