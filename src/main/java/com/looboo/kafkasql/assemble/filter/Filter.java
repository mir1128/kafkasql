package com.looboo.kafkasql.assemble.filter;

public interface Filter {
    boolean predicate(Object object);

    default boolean isPartition() {
        return false;
    }

    default boolean isTimestamp() {
        return false;
    }

    default boolean isFunction() {
        return false;
    }

    default boolean isStr() {
        return false;
    }

    default boolean isByte() {
        return false;
    }
}
