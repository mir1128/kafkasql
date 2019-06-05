package com.looboo.kafkasql.grammar;

import com.looboo.kafkasql.parser.KafkaSqlParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TokenTest extends TestBase {

    @Test
    public void test_tpoicStatement() throws IOException {
        KafkaSqlParser parser = buildParser("* from test-topic-1".toUpperCase());
        ParseTree tree = parser.querySpecification();
        Assert.assertFalse(hasErrorNode(tree));
        System.out.println(tree.toStringTree(parser));
    }
}
