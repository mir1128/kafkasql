package com.looboo.kafkasql;

import com.looboo.kafkasql.parser.KafkaSqlParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SyntaxTest extends TestBase {

    private List<String> sqls = Arrays.asList(
            "select * from topic",
            "select * from topic where partition = 0",
            "select * from topic where partition in (0,1,2,3)",
            "select * from topic where str(key) = 'aaa'",
            "select * from topic where timestamp = 1332232323155",
            "select * from topic where timestamp in (1332232323155, 133223232315212)",
            "select * from topic where timestamp between(1332232323155, 133223232315212)",

            "select byte(key), byte(value) from topic",
            "select json(key), json(value) from topic",
            "select str(key), str(value) from topic",

            "select offsets(topic)",
            "select offsets(topic.1)",

            "select partitions(topic)",

            "select consumers(topic)",
            "select consumer_offset(topic)");

    @Test
    public void test_select_clause2() {
        for (int i = 0; i < sqls.size(); ++i) {
            System.out.println(i);
            String s = sqls.get(i);
            parsingAndAssert(s);
        }
    }

    private void parsingAndAssert(String s) {
        KafkaSqlParser parser = buildParser(s.toUpperCase());
        ParseTree tree = parser.selectStatement();
        Assert.assertFalse(hasErrorNode(tree));
    }
}
