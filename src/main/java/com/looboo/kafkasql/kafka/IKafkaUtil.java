package com.looboo.kafkasql.kafka;

import org.antlr.v4.runtime.misc.Pair;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

public interface IKafkaUtil {

    Collection<String> listTopics();

    Collection<Integer> listPartitions(String topic);

    Future<Collection<ConsumerRecord>> poll(String topic);

    Future<Collection<ConsumerRecord>> poll(String topic, List<Integer> partitions);

    Future<Collection<ConsumerRecord>> getMessageBetween(Long startTimestamp, Long endTimestamp);

    Future<Collection<ConsumerRecord>> getMessageInTimeStamp(List<Long> timestamps);

    //offset
    Collection<Integer> getOffset(String topic);

    Collection<Integer> getOffset(String topic, List<Integer> partitions);

    Collection<Integer> getPartitions(String topic);

    Collection<String> listConsumer(String topic);

    Collection<Pair<String, Integer>> listConsumerOffset(String topic, String consumerName);
}
