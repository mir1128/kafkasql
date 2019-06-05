package com.looboo.kafkasql.kafka;

import org.antlr.v4.runtime.misc.Pair;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class KafkaUtil implements IKafkaUtil {

    private AdminClient adminClient;
    private Consumer consumer;

    public KafkaUtil(KafkaConsumerConfig kafkaConsumerConfig) {
        adminClient = AdminClient.create(kafkaConsumerConfig.getAdminClientProperties());
        consumer = new KafkaConsumer(kafkaConsumerConfig.getConsumerProperties());
    }

    public AdminClient getAdminClient() {
        return adminClient;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    @Override
    public Collection<String> listTopics() {
        try {
            return adminClient.listTopics().names().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public Collection<Integer> listPartitions(String topic) {
        return null;
    }

    @Override
    public Future<Collection<ConsumerRecord>> poll(String topic) {
        return null;
    }

    @Override
    public Future<Collection<ConsumerRecord>> poll(String topic, List<Integer> partitions) {
        return null;
    }

    @Override
    public Future<Collection<ConsumerRecord>> getMessageBetween(Long startTimestamp, Long endTimestamp) {
        return null;
    }

    @Override
    public Future<Collection<ConsumerRecord>> getMessageInTimeStamp(List<Long> timestamps) {
        return null;
    }

    @Override
    public Collection<Integer> getOffset(String topic) {
        return null;
    }

    @Override
    public Collection<Integer> getOffset(String topic, List<Integer> partitions) {
        return null;
    }

    @Override
    public Collection<Integer> getPartitions(String topic) {
        return null;
    }

    @Override
    public Collection<String> listConsumer(String topic) {
        return null;
    }

    @Override
    public Collection<Pair<String, Integer>> listConsumerOffset(String topic, String consumerName) {
        return null;
    }
}
