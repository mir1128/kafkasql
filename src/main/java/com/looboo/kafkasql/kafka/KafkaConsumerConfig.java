package com.looboo.kafkasql.kafka;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.OffsetResetStrategy;
import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Type;
import org.apache.kafka.common.config.ConfigDef.Validator;
import org.apache.kafka.common.config.ConfigException;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class KafkaConsumerConfig extends AbstractConfig {

    private static final Validator NON_EMPTY_LIST_VALIDATOR = (name, value) -> {
        if (((List<String>) value).isEmpty()) {
            throw new ConfigException("At least one bootstrap server must be configured in " + name);
        }
    };

    public static final ConfigDef.ValidString CONSUMER_AUTO_OFFSET_RESET_VALIDATOR = ConfigDef.ValidString.in(
            OffsetResetStrategy.EARLIEST.toString().toLowerCase(), OffsetResetStrategy.LATEST.toString().toLowerCase(),
            OffsetResetStrategy.NONE.toString().toLowerCase());

    public static final String BOOTSTRAP_SERVERS_CONFIG_DEFAULT = "localhost:19092";

    public static final String CONSUMER_AUTO_OFFSET_RESET_DEFAULT = "earliest";
    public static final String CONSUMER_AUTO_OFFSET_RESET_DOC = "consumer auto offset reset doc.";

    public static final String CONSUMER_ENABLE_AUTO_COMMIT_DEFAULT = "false";
    public static final String CONSUMER_ENABLE_AUTO_COMMIT_DOC = "enable auto commit. if set true, use __consumer_offsets to record offset.";

    public static final String CONSUMER_KEY_DESERIALIZER_DEFAULT = "org.apache.kafka.common.serialization.ByteArrayDeserializer";
    public static final String CONSUMER_KEY_DESERIALIZER_DOC = "key deserializer";

    public static final String CONSUMER_VALUE_DESERIALIZER_DEFAULT = "org.apache.kafka.common.serialization.ByteArrayDeserializer";
    public static final String CONSUMER_VALUE_DESERIALIZER_DOC = "value deserializer";

    public static final String CONSUMER_MAX_POLL_RECORDS_DEFAULT = "5000";
    public static final String CONSUMER_MAX_POLL_RECORDS_DOC = "max poll records once";

    public static final String MAX_POLL_INTERVAL_MS_CONFIG_DEFAULT = "50";
    public static final String MAX_POLL_INTERVAL_MS_DOC = "max.poll.interval.ms";


    public static final String CONSUMER_GROUP_ID_DOC = "group id";
    public static final Object CONSUMER_GROUP_ID_DEFAULT = "kafkasql-group";

    public static final ConfigDef CONFIG = new ConfigDef()
            .define(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, Type.LIST, BOOTSTRAP_SERVERS_CONFIG_DEFAULT,
                    NON_EMPTY_LIST_VALIDATOR, ConfigDef.Importance.HIGH, CommonClientConfigs.BOOTSTRAP_SERVERS_DOC)
            .define(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, Type.STRING, CONSUMER_AUTO_OFFSET_RESET_DEFAULT, CONSUMER_AUTO_OFFSET_RESET_VALIDATOR,
                    ConfigDef.Importance.MEDIUM, CONSUMER_AUTO_OFFSET_RESET_DOC)
            .define(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, Type.BOOLEAN, CONSUMER_ENABLE_AUTO_COMMIT_DEFAULT,
                    ConfigDef.Importance.LOW, CONSUMER_ENABLE_AUTO_COMMIT_DOC)
            .define(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, Type.STRING, CONSUMER_KEY_DESERIALIZER_DEFAULT,
                    ConfigDef.Importance.LOW, CONSUMER_KEY_DESERIALIZER_DOC)
            .define(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, Type.STRING, CONSUMER_VALUE_DESERIALIZER_DEFAULT,
                    ConfigDef.Importance.LOW, CONSUMER_VALUE_DESERIALIZER_DOC)
            .define(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, Type.INT, CONSUMER_MAX_POLL_RECORDS_DEFAULT,
                    ConfigDef.Importance.LOW, CONSUMER_MAX_POLL_RECORDS_DOC)
            .define(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, Type.INT, MAX_POLL_INTERVAL_MS_CONFIG_DEFAULT,
                    ConfigDef.Importance.LOW, MAX_POLL_INTERVAL_MS_DOC)
            .define(ConsumerConfig.GROUP_ID_CONFIG, Type.STRING, CONSUMER_GROUP_ID_DEFAULT,
                    ConfigDef.Importance.HIGH, CONSUMER_GROUP_ID_DOC);

    public KafkaConsumerConfig(Map<String, String> props) {
        super(CONFIG, props);
    }

    public Properties getAdminClientProperties() {
        Properties adminClientProps = new Properties();
        adminClientProps.putAll(values());
        return adminClientProps;
    }

    public Properties getConsumerProperties() {
        Properties adminClientProps = new Properties();
        adminClientProps.putAll(values());
        return adminClientProps;
    }
}

