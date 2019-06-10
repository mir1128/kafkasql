package com.looboo.kafkasql.assemble.filter;

import org.antlr.v4.runtime.misc.Pair;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class BetweenFilter extends AbstractFilter {

    public BetweenFilter(Object operand, String field, String function) {
        super(operand, field, function);
    }

    @Override
    public boolean predicate(Object object) {
        if (!(this.operand instanceof Pair)) return true;

        Pair<String, String> operandPair = (Pair<String, String>) this.operand;

        if (operandPair.a == null || operandPair.a.isEmpty()
                || operandPair.b == null || operandPair.b.isEmpty()) {
            return true;
        }

        if (isPartition()) {
            Integer o1 = (Integer) object;
            return Integer.valueOf(operandPair.a) <= o1 && o1 <= Integer.valueOf(operandPair.b);
        } else if (isTimestamp()) {
            ConsumerRecord record = (ConsumerRecord) object;
            return Long.valueOf(operandPair.a) <= record.timestamp() && record.timestamp() <= Long.valueOf(operandPair.b);
        }

        return true;
    }
}

