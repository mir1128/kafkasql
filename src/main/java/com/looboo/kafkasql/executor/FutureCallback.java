package com.looboo.kafkasql.executor;

public class FutureCallback<T> extends ConvertingFutureCallback<T, T> {

    public FutureCallback(Callback<T> underlying) {
        super(underlying);
    }

    public FutureCallback() {
        super(null);
    }

    @Override
    public T convert(T result) {
        return result;
    }
}
