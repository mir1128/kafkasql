package com.looboo.kafkasql.assemble;

public interface Filter<T> {
    boolean predicate(T value);
}
