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

}
