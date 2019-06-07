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
public class ProcessorFactory {

    public static Processor createProcessor(ParseTree tree, KafkaUtil util) {
        if (tree instanceof KafkaSqlParser.OffsetStatementContext) {
            return new OffsetStatementProcessor(util);
        } else if (tree instanceof KafkaSqlParser.QuerySpecificationContext) {
            return new QuerySpecificationProcessor(util);
        } else if (tree instanceof TopicStatementProcessor) {
            return new TopicStatementProcessor(util);
        } else if (tree instanceof KafkaSqlParser.PartitionsStatementContext) {
            return new PartitionStatementProcessor(util);
        } else if (tree instanceof KafkaSqlParser.ConsumersStatementContext) {
            return new ConsumerStatementProcessor(util);
        } else if (tree instanceof KafkaSqlParser.ConsumerOffsetStatementContext) {
            return new ConsumerOffsetStatementProcessor(util);
        } else {
//            log.error("[error] not a valid statement");
            return null;
        }
    }
}
