package com.looboo.kafkasql.assemble.filter;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class EqualFilter extends AbstractFilter {

    public EqualFilter(Object operand, String field, String function) {
        super(operand, field, function);
    }

    @Override
    public boolean predicate(Object object) {
        if (isPartition()) {
            String operandString = (String) this.operand;
            if (operandString == null || operandString.isEmpty()) return true;
            return Integer.valueOf(operandString).equals(object);
        } else if (isTimestamp()) {
            ConsumerRecord record = (ConsumerRecord) object;
            String operandString = (String) this.operand;

            if (operandString == null || operandString.isEmpty()) return true;
            return Long.valueOf(operandString).equals(record.timestamp());
        }
        else if (isFunction()) {

        }
        return true;
    }
}
