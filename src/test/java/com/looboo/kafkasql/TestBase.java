package com.looboo.kafkasql;

import com.looboo.kafkasql.parser.KafkaSqlLexer;
import com.looboo.kafkasql.parser.KafkaSqlParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNodeImpl;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class TestBase {
    protected boolean hasErrorNode(ParseTree tree) {
        int childCount = tree.getChildCount();
        for (int i = 0; i < childCount; ++i) {
            if (tree.getChild(i) instanceof ErrorNodeImpl) {
                return true;
            }
        }
        return false;
    }

    protected KafkaSqlParser buildParser(String sql)  {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(sql.getBytes());
        ANTLRInputStream input = null;
        try {
            input = new ANTLRInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        KafkaSqlLexer lexer = new KafkaSqlLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        return new KafkaSqlParser(tokenStream);
    }

}
