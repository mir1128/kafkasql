package com.looboo.kafkasql.assemble;

import org.antlr.v4.runtime.tree.ParseTree;

public interface SelectProcessor {
    String process(ParseTree tree);
}
