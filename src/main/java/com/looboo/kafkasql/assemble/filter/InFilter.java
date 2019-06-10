package com.looboo.kafkasql.assemble.filter;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.List;

public class InFilter extends AbstractFilter {

    public InFilter(Object operand, String field, String function) {
        super(operand, field, function);
    }

    @Override
    public boolean predicate(Object object) {
        if (isPartition()) {
            return ((List<String>)operand).stream()
                    .map(o -> Integer.valueOf(o))
                    .filter(o -> o.equals(object))
                    .findAny()
                    .isPresent();
        } else if (isTimestamp()){
            List<String> operands = (List<String>) this.operand;

            if (object instanceof ConsumerRecord) {
                ConsumerRecord record = (ConsumerRecord) object;
                return operands.stream().map(o -> Long.valueOf(o))
                        .filter(o -> o.equals(record.timestamp()))
                        .findAny()
                        .isPresent();
            }
        }
        return false;
    }

}
