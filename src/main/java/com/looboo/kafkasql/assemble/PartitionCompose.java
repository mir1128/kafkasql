package com.looboo.kafkasql.assemble;

import java.util.List;

public class PartitionCompose implements Filter<Integer> {

    private List<Filter> filters;

    public PartitionCompose(List<Filter> filters) {
        this.filters = filters;
    }

    public PartitionCompose addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean predicate(Integer value) {
        return filters.stream().allMatch(f -> f.predicate(value));
    }
}
