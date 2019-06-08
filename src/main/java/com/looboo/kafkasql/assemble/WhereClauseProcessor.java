package com.looboo.kafkasql.assemble;

import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

public interface WhereClauseProcessor {
    List<Filter> generateFilters(ParseTree tree);
}
