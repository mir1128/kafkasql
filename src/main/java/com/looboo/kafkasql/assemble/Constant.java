package com.looboo.kafkasql.assemble;

import com.looboo.kafkasql.parser.KafkaSqlLexer;
import com.looboo.kafkasql.parser.KafkaSqlParser;

public class Constant {
    public final static String STAR = KafkaSqlLexer.VOCABULARY.getSymbolicName(KafkaSqlLexer.STAR);
    public final static String FROM = KafkaSqlLexer.VOCABULARY.getSymbolicName(KafkaSqlLexer.FROM);
    public final static String WHERE = KafkaSqlLexer.VOCABULARY.getSymbolicName(KafkaSqlLexer.WHERE);
    public final static String PARTITION = KafkaSqlLexer.VOCABULARY.getSymbolicName(KafkaSqlLexer.PARTITION);
    public final static String TIMESTAMP = KafkaSqlLexer.VOCABULARY.getSymbolicName(KafkaSqlLexer.TIMESTAMP);
    public final static String STR = KafkaSqlLexer.VOCABULARY.getSymbolicName(KafkaSqlLexer.STR);
    public final static String BYTE = KafkaSqlLexer.VOCABULARY.getSymbolicName(KafkaSqlLexer.BYTE);
    public final static String OFFSETS = KafkaSqlParser.VOCABULARY.getSymbolicName(KafkaSqlLexer.OFFSETS);
    public final static String PARTITIONS = KafkaSqlParser.VOCABULARY.getSymbolicName(KafkaSqlLexer.PARTITIONS);
}
