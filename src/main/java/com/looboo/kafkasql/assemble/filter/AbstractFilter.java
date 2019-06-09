package com.looboo.kafkasql.assemble.filter;

import static com.looboo.kafkasql.assemble.Constant.BYTE;
import static com.looboo.kafkasql.assemble.Constant.JSON;
import static com.looboo.kafkasql.assemble.Constant.PARTITION;
import static com.looboo.kafkasql.assemble.Constant.STR;
import static com.looboo.kafkasql.assemble.Constant.TIMESTAMP;

public abstract class AbstractFilter implements Filter {
    protected Object operand;
    protected String field;
    protected String function;

    public AbstractFilter(Object operand, String field, String function) {
        this.operand = operand;
        this.field = field;
        this.function = function;
    }

    public boolean isPartition() {
        return field.equals(PARTITION);
    }

    public boolean isTimestamp() {
        return field.equals(TIMESTAMP);
    }

    @Override
    public boolean isFunction() {
        return !isTimestamp() && !isPartition();
    }

    @Override
    public boolean isStr() {
        return isFunction() && function.equals(STR);
    }

    @Override
    public boolean isJson() {
        return isFunction() && function.equals(JSON);
    }

    @Override
    public boolean isByte() {
        return isFunction() && function.equals(BYTE);
    }

    abstract public boolean predicate(Object object);
}
