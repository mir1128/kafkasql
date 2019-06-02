package com.looboo.kafkasql;


import com.looboo.kafkasql.parser.KafkaSqlLexer;
import com.looboo.kafkasql.parser.KafkaSqlParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNodeImpl;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class GrammarTest {

    private final String selectClause1  = "select * from topic";
    private final String selectClause2  = "select * from topic where partition = 0";
    private final String selectClause3  = "select * from topic where partition in (0,1,2,3)";
    private final String selectClause4  = "select * from topic where str(key) = 'aaa'";
    private final String selectClause5  = "select * from topic where str(key) in('aaa', 'bbb', 'ccc')";
    private final String selectClause6  = "select * from topic where timestamp = 1332232323155";
    private final String selectClause7  = "select * from topic where timestamp in (1332232323155, 133223232315212)";
    private final String selectClause8  = "select * from topic where timestamp between(1332232323155, 133223232315212)";

    private final String format1 = "select byte(key), byte(value) from topic";
    private final String format2 = "select json(key), json(value) from topic";
    private final String format3 = "select str(key), str(value) from topic";

    private final String offsets1 = "select offsets(topic)";
    private final String offsets2 = "select offsets(topic.partition)";

    private final String partitions = "select partitions(topic)";

    private final String consumer = "select consumers(topic)";
    private final String consumerOffset = "select consumer_offset(topic)";


    private KafkaSqlParser buildParser(String sql) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(sql.getBytes());
        ANTLRInputStream input = new ANTLRInputStream(inputStream);

        KafkaSqlLexer lexer = new KafkaSqlLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        return new KafkaSqlParser(tokenStream);
    }

//    @Test
//    public void test_querySpecification() throws IOException {
//        KafkaSqlParser parser = buildParser("* from topic".toUpperCase());
//        ParseTree tree = parser.querySpecification();
//        String s = tree.toStringTree(parser);
//        Assert.assertEquals(s, "(querySpecification * FROM TOPIC)");
//    }

    @Test
    public void test_offsetStatement() throws IOException {
        KafkaSqlParser parser = buildParser("offsets(topic)".toUpperCase());
        ParseTree tree = parser.offsetStatement();
        Assert.assertFalse(hasErrorNode(tree));
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void test_offsetStatement_with_partitions() throws IOException {
        KafkaSqlParser parser = buildParser("offsets(topic.1)".toUpperCase());
        ParseTree tree = parser.offsetStatement();
        Assert.assertFalse(hasErrorNode(tree));
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void test_partitionsStatement() throws IOException {
        KafkaSqlParser parser = buildParser("partitions(topic)".toUpperCase());
        ParseTree tree = parser.partitionsStatement();
        Assert.assertFalse(hasErrorNode(tree));
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void test_consumerStatement() throws IOException {
        KafkaSqlParser parser = buildParser("consumers(topic)".toUpperCase());
        ParseTree tree = parser.consumersStatement();
        Assert.assertFalse(hasErrorNode(tree));
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void test_consumerOffsetStatement() throws IOException {
        KafkaSqlParser parser = buildParser("consumer_offset(topic)".toUpperCase());
        ParseTree tree = parser.consumerOffsetStatement();
        Assert.assertFalse(hasErrorNode(tree));
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void test_selectStatement_consumer_offset() throws IOException {
        KafkaSqlParser parser = buildParser("select consumer_offset(topic)".toUpperCase());
        ParseTree tree = parser.selectStatement();
        Assert.assertFalse(hasErrorNode(tree));
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void test_numberList() throws IOException {
        KafkaSqlParser parser = buildParser("1212, 12114".toUpperCase());
        ParseTree tree = parser.numberList();
        Assert.assertFalse(hasErrorNode(tree));
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void test_charsList() throws IOException {
        KafkaSqlParser parser = buildParser("'123', '12114'".toUpperCase());
        ParseTree tree = parser.charsList();
        Assert.assertFalse(hasErrorNode(tree));
        Assert.assertFalse(hasErrorNode(tree));
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void test_inclause_numberlist() throws IOException {
        KafkaSqlParser parser = buildParser("xxxx in (12,3,4,5,56)".toUpperCase());
        ParseTree tree = parser.inCluase();
        Assert.assertFalse(hasErrorNode(tree));
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void test_inclause_charslist() throws IOException {
        KafkaSqlParser parser = buildParser("xxxx in ('12','3','4','5','56')".toUpperCase());
        ParseTree tree = parser.inCluase();
        Assert.assertFalse(hasErrorNode(tree));
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void test_inclause_error_case() throws IOException {
        KafkaSqlParser parser = buildParser("xxxx in ('12','3','4','5',56)".toUpperCase());
        ParseTree tree = parser.inCluase();

        Assert.assertTrue(hasErrorNode(tree));
    }

    @Test
    public void test_between() throws IOException {
        KafkaSqlParser parser = buildParser("aaa between (1212, 212)".toUpperCase());
        ParseTree tree = parser.betweenCluase();

        Assert.assertFalse(hasErrorNode(tree));
    }

    @Test
    public void test_partitionsEquslCluase() throws IOException {
        KafkaSqlParser parser = buildParser("partition = 12121".toUpperCase());
        ParseTree tree = parser.partitionsEquslCluase();
        Assert.assertFalse(hasErrorNode(tree));
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void test_timestampEquslCluase() throws IOException {
        KafkaSqlParser parser = buildParser("timestamp = 12121".toUpperCase());
        ParseTree tree = parser.timestampEquslCluase();
        Assert.assertFalse(hasErrorNode(tree));
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void test_valueEqualClause() throws IOException {
        KafkaSqlParser parser = buildParser("byte(asdf) = 12121".toUpperCase());
        ParseTree tree = parser.valueEqualClause();
        Assert.assertFalse(hasErrorNode(tree));
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void test_equationClause() throws IOException {
        KafkaSqlParser parser = buildParser("byte(asdf) = 12121".toUpperCase());
        ParseTree tree = parser.valueEqualClause();
        Assert.assertFalse(hasErrorNode(tree));
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void test_whereClause() throws IOException {
        KafkaSqlParser parser = buildParser("where byte(asdf) = 12121".toUpperCase());
        ParseTree tree = parser.whereClause();
        Assert.assertFalse(hasErrorNode(tree));
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void test_querySpecification() throws IOException {
        KafkaSqlParser parser = buildParser("* from abc where byte(asdf) = 12121".toUpperCase());
        ParseTree tree = parser.querySpecification();
        Assert.assertFalse(hasErrorNode(tree));
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void test_querySpecification1() throws IOException {
        KafkaSqlParser parser = buildParser("byte(key) from abc where byte(asdf) = 12121".toUpperCase());
        ParseTree tree = parser.querySpecification();
        Assert.assertFalse(hasErrorNode(tree));
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void test_querySpecification2() throws IOException {
        KafkaSqlParser parser = buildParser("xxxx from abc where byte(asdf) = 12121".toUpperCase());
        ParseTree tree = parser.querySpecification();
        Assert.assertFalse(hasErrorNode(tree));
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void test_selectStatement() throws IOException {
        KafkaSqlParser parser = buildParser(" select xxxx from abc where byte(asdf) = 12121".toUpperCase());
        ParseTree tree = parser.selectStatement();
        Assert.assertFalse(hasErrorNode(tree));
        System.out.println(tree.toStringTree(parser));
    }



    private boolean hasErrorNode(ParseTree tree) {
        int childCount = tree.getChildCount();
        for (int i = 0; i < childCount; ++i) {
            if (tree.getChild(i) instanceof ErrorNodeImpl) {
                return true;
            }
        }
        return false;
    }
}
