package com.looboo.kafkasql.assemble.filter;

import java.util.List;

public class InFilter extends AbstractFilter {

    public InFilter(Object operand, String field, String function) {
        super(operand, field, function);
    }

    @Override
    public boolean predicate(Object object) {
        if (isPartition() || isTimestamp()) {
            return ((List<Integer>)operand).stream().anyMatch(o -> o.equals(object));
        } else {

        }
        return false;
    }

}
