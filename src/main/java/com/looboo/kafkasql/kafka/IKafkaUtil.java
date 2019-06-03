package com.looboo.kafkasql.kafka;

import org.antlr.v4.runtime.misc.Pair;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.List;
import java.util.concurrent.Future;

public interface IKafkaUtil {

    List<String> listTopics();

    List<Integer> listPartitions(String topic);

    Future<List<ConsumerRecord>> poll(String topic);

    Future<List<ConsumerRecord>> poll(String topic, List<Integer> partitions);

    Future<List<ConsumerRecord>> getMessageBetween(Long startTimestamp, Long endTimestamp);

    Future<List<ConsumerRecord>> getMessageInTimeStamp(List<Long> timestamps);

    //offset
    List<Integer> getOffset(String topic);

    List<Integer> getOffset(String topic, List<Integer> partitions);

    List<Integer> getPartitions(String topic);

    List<String> listConsumer(String topic);

    List<Pair<String, Integer>> listConsumerOffset(String topic, String consumerName);
}
