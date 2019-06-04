package com.looboo.kafkasql.kafka;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.consumer.Consumer;

public class KafkaManager {
    private AdminClient adminClient;
    private Consumer consumer;

    public KafkaManager(KafkaConfig kafkaConfig) {

    }
}
