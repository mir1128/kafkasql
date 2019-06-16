package com.looboo.kafkasql.executor;

import lombok.Data;

import java.util.Objects;
import java.util.concurrent.Callable;

@Data
public class SqlExecutionRequest implements SqlRequest, Comparable<SqlExecutionRequest>{
    private final long at;
    private final long seq;
    private final Callable<Void> action;
    private final Callback<Void> callback;

    public SqlExecutionRequest(long at, long seq, Callable<Void> action, Callback<Void> callback) {
        this.at = at;
        this.seq = seq;
        this.action = action;
        this.callback = callback;
    }

    public Callable<Void> action() {
        return action;
    }

    public Callback<Void> callback() {
        return callback;
    }

    @Override
    public void cancel() {
    }

    @Override
    public int compareTo(SqlExecutionRequest o) {
        final int cmp = Long.compare(at, o.at);
        return cmp == 0 ? Long.compare(seq, o.seq) : cmp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SqlExecutionRequest))
            return false;
        SqlExecutionRequest other = (SqlExecutionRequest) o;
        return compareTo(other) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(at, seq);
    }
}
