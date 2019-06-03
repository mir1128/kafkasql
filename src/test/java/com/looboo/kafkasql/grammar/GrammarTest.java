package com.looboo.kafkasql.grammar;


import com.looboo.kafkasql.parser.KafkaSqlParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class GrammarTest extends TestBase {


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
        KafkaSqlParser parser = buildParser("partition in (12,3,4,5,56)".toUpperCase());
        ParseTree tree = parser.inCluase();
        Assert.assertFalse(hasErrorNode(tree));
        System.out.println(tree.toStringTree(parser));
    }

    @Test
    public void test_inclause_charslist() throws IOException {
        KafkaSqlParser parser = buildParser("partition in ('12','3','4','5','56')".toUpperCase());
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
        KafkaSqlParser parser = buildParser("partition between (1212, 212)".toUpperCase());
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
}
