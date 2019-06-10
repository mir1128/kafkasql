package com.looboo.kafkasql.assemble.filter;

import java.util.List;

public class InFilter extends AbstractFilter {

    public InFilter(Object operand, String field, String function) {
        super(operand, field, function);
    }

    @Override
    public boolean predicate(Object object) {
        if (isPartition() || isTimestamp()) {
            return ((List<String>)operand).stream()
                    .map(o -> Integer.valueOf(o))
                    .filter(o -> o.equals(object))
                    .findAny()
                    .isPresent();
        } else {

        }
        return false;
    }

}
