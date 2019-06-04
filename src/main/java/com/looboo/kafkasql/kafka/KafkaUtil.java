package com.looboo.kafkasql.kafka;

import org.antlr.v4.runtime.misc.Pair;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.List;
import java.util.concurrent.Future;

public class KafkaUtil implements IKafkaUtil {

    @Override
    public List<String> listTopics() {
        return null;
    }

    @Override
    public Future<List<ConsumerRecord>> poll(String topic, List<Integer> partitions) {
        return null;
    }

    @Override
    public Future<List<ConsumerRecord>> getMessageBetween(Long startTimestamp, Long endTimestamp) {
        return null;
    }

    @Override
    public Future<List<ConsumerRecord>> getMessageInTimeStamp(List<Long> timestamps) {
        return null;
    }

    @Override
    public List<Integer> getOffset(String topic) {
        return null;
    }

    @Override
    public List<Integer> getOffset(String topic, List<Integer> partitions) {
        return null;
    }

    @Override
    public List<Integer> getPartitions(String topic) {
        return null;
    }

    @Override
    public List<String> listConsumer(String topic) {
        return null;
    }

    @Override
    public List<Pair<String, Integer>> listConsumerOffset(String topic, String consumerName) {
        return null;
    }

    @Override
    public List<Integer> listPartitions(String topic) {
        return null;
    }

    @Override
    public Future<List<ConsumerRecord>> poll(String topic) {
        return null;
    }

}
