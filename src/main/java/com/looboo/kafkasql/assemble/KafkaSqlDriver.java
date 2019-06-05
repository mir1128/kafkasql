package com.looboo.kafkasql.assemble;

import com.looboo.kafkasql.parser.KafkaSqlLexer;
import com.looboo.kafkasql.parser.KafkaSqlParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class KafkaSqlDriver {

    public void parsing(String sql) {
        KafkaSqlParser parser = buildParser(sql.toUpperCase());
        ParseTree tree = parser.selectStatement();
    }

    private KafkaSqlParser buildParser(String sql)  {
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
