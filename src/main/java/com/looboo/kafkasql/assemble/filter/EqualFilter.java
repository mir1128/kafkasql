package com.looboo.kafkasql.assemble.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;

import java.util.Arrays;

@Slf4j
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
            ConsumerRecord record = (ConsumerRecord) object;

            if (isStr()) {
                if (field.equalsIgnoreCase("key")) {
                    String keyString = new StringDeserializer().deserialize("", (byte[]) record.key());
                    return keyString.equalsIgnoreCase(trimSingleQuote((String) operand));
                } else if (field.equalsIgnoreCase("value")) {
                    String valueString = new StringDeserializer().deserialize("", (byte[]) record.value());
                    return valueString.equalsIgnoreCase(trimSingleQuote((String) operand));
                } else {
                    log.warn("unsupported field: {}", field);
                }
            } else if (isByte()) {
                if (field.equalsIgnoreCase("key")) {
                    byte[] keyArray = new ByteArrayDeserializer().deserialize("", (byte[]) record.key());
                    return Arrays.equals(keyArray, (byte[]) operand);
                } else if (field.equalsIgnoreCase("value")) {
                    byte[] valueArray = new ByteArrayDeserializer().deserialize("", (byte[]) record.key());
                    return Arrays.equals(valueArray, (byte[]) operand);
                } else {
                    log.warn("unsupported field: {}", field);
                }
            } else {
                log.warn("unsupported function: {}", function);
            }
        }
        return true;
    }

}
