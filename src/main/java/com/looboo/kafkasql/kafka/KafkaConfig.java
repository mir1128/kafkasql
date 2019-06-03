package com.looboo.kafkasql.kafka;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

import java.util.Map;

public class KafkaConfig extends AbstractConfig {
    public KafkaConfig(ConfigDef definition, Map<?, ?> originals, boolean doLog) {
        super(definition, originals, doLog);
    }

    public KafkaConfig(ConfigDef definition, Map<?, ?> originals) {
        super(definition, originals);
    }
}
