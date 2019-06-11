package com.looboo.kafkasql.assemble.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.List;

@Slf4j
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
        } else if (isFunction()) {
            ConsumerRecord record = (ConsumerRecord) object;

            if (isStr()) {
                if (field.equalsIgnoreCase("key")) {
                    String keyString = new StringDeserializer().deserialize("", (byte[]) record.key());

                    return ((List<String>)operand).stream()
                            .map(s -> trimSingleQuote(s))
                            .filter(o -> o.equalsIgnoreCase(keyString))
                            .findAny()
                            .isPresent();
                } else if (field.equalsIgnoreCase("value")) {
                    String valueString = new StringDeserializer().deserialize("", (byte[]) record.value());
                    return ((List<String>)operand).stream()
                            .map(s -> trimSingleQuote(s))
                            .filter(o -> o.equalsIgnoreCase(valueString))
                            .findAny()
                            .isPresent();
                } else {
                    log.warn("unsupported field: {}", field);
                }
            } else if (isByte()) {
                if (field.equalsIgnoreCase("key")) {
                    byte[] keyArray = new ByteArrayDeserializer().deserialize("", (byte[]) record.key());
                    return ((List<String>)operand).stream().map(o -> o.getBytes()).filter(array -> Arrays.equals(keyArray, array)).findAny().isPresent();
                } else if (field.equalsIgnoreCase("value")) {
                    byte[] valueArray = new ByteArrayDeserializer().deserialize("", (byte[]) record.key());
                    return ((List<String>)operand).stream().map(o -> o.getBytes()).filter(array -> Arrays.equals(valueArray, array)).findAny().isPresent();
                } else {
                    log.warn("unsupported field: {}", field);
                }
            } else {
                log.warn("unsupported function: {}", function);
            }
        } else {

        }
        return false;
    }

}
