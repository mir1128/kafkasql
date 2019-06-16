package com.looboo.kafkasql.executor;

public interface Callback<V> {
    void onCompletion(Throwable error, V result);
}
