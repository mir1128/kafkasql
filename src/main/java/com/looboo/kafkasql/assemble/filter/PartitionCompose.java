package com.looboo.kafkasql.assemble.filter;

import java.util.List;

public class PartitionCompose implements Filter {

    List<Filter> filters;

    public PartitionCompose(List<Filter> filters) {
        this.filters = filters;
    }

    @Override
    public boolean predicate(Object object) {
        return filters.stream().allMatch(f -> f.predicate(object));
    }

    @Override
    public boolean isPartition() {
        return false;
    }

    @Override
    public boolean isTimestamp() {
        return false;
    }

    @Override
    public boolean isFunction() {
        return false;
    }

    @Override
    public boolean isStr() {
        return false;
    }

    @Override
    public boolean isJson() {
        return false;
    }

    @Override
    public boolean isByte() {
        return false;
    }
}
