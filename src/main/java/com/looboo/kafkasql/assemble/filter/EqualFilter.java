package com.looboo.kafkasql.assemble.filter;

public class EqualFilter extends AbstractFilter {

    public EqualFilter(Object operand, String field, String function) {
        super(operand, field, function);
    }

    @Override
    public boolean predicate(Object object) {
        if (isPartition() || isTimestamp()) {
            return operand.equals(object);
        } else if (isFunction()){

        }
        return true;
    }
}
