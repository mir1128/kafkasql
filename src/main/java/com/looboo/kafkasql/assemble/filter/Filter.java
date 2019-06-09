package com.looboo.kafkasql.assemble.filter;

public interface Filter {
    boolean predicate(Object object);

    boolean isPartition();

    boolean isTimestamp();

    boolean isFunction();

    boolean isStr();

    boolean isJson();

    boolean isByte();
}
