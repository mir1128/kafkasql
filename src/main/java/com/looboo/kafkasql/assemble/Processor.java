package com.looboo.kafkasql.assemble;

import org.antlr.v4.runtime.tree.ParseTree;

public interface Processor {
    void process(ParseTree tree);
}
