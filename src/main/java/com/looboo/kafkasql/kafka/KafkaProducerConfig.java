package com.looboo.kafkasql.kafka;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Type;
import org.apache.kafka.common.config.ConfigException;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class KafkaProducerConfig extends AbstractConfig {

    private static final ConfigDef.Validator NON_EMPTY_LIST_VALIDATOR = new ConfigDef.Validator() {
        @Override
        @SuppressWarnings("unchecked")
        public void ensureValid(String name, Object value) {
            if (((List<String>) value).isEmpty()) {
                throw new ConfigException("At least one bootstrap server must be configured in " + name);
            }
        }
    };

    public static final String BOOTSTRAP_SERVERS_CONFIG_DEFAULT = "localhost:19092";

    public static final String ACKS_CONFIG_DOC = "ack config";

    public static final String KEY_SERIALIZER_CLASS_DEFAULT = "org.apache.kafka.common.serialization.StringSerializer";
    public static final String VALUE_SERIALIZER_CLASS_DEFAULT = "org.apache.kafka.common.serialization.StringSerializer";

    public static final ConfigDef CONFIG = new ConfigDef()
            .define(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Type.LIST, BOOTSTRAP_SERVERS_CONFIG_DEFAULT,
                    NON_EMPTY_LIST_VALIDATOR, ConfigDef.Importance.HIGH, CommonClientConfigs.BOOTSTRAP_SERVERS_DOC)
            .define(ProducerConfig.ACKS_CONFIG, Type.STRING, "all", ConfigDef.Importance.LOW,
                    ACKS_CONFIG_DOC)
            .define(ProducerConfig.RETRIES_CONFIG, Type.INT, 0, ConfigDef.Importance.LOW,"")
            .define(ProducerConfig.BATCH_SIZE_CONFIG, Type.INT, 16384, ConfigDef.Importance.LOW,"")
            .define(ProducerConfig.LINGER_MS_CONFIG, Type.INT, 1, ConfigDef.Importance.LOW, "")
            .define(ProducerConfig.BUFFER_MEMORY_CONFIG, Type.INT, 33554432, ConfigDef.Importance.LOW, "")
            .define(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, Type.STRING, KEY_SERIALIZER_CLASS_DEFAULT, ConfigDef.Importance.LOW, "")
            .define(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, Type.STRING, VALUE_SERIALIZER_CLASS_DEFAULT, ConfigDef.Importance.LOW, "");

    public KafkaProducerConfig(Map<String, String> props) {
        super(CONFIG, props);
    }


    public Properties getProducerProperties() {
        Properties adminClientProps = new Properties();
        adminClientProps.putAll(values());
        return adminClientProps;
    }
}
