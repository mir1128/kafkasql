package com.looboo.kafkasql.kafka;

import org.antlr.v4.runtime.misc.Pair;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

public interface IKafkaUtil {

    Collection<String> listTopics();

    Collection<Integer> listPartitions(String topic);

    Map<TopicPartition, List<ConsumerRecord>> poll(String topic);

    Map<TopicPartition, List<ConsumerRecord>> poll(String topic, Map<TopicPartition, Long> partitionLongMap);

    Future<Collection<ConsumerRecord>> getMessageBetween(Long startTimestamp, Long endTimestamp);

    Future<Collection<ConsumerRecord>> getMessageInTimeStamp(List<Long> timestamps);

    //offset
    Map<TopicPartition, Long> getOffset(String topic);

    Collection<Integer> getOffset(String topic, List<Integer> partitions);

    Collection<Integer> getPartitions(String topic);

    Collection<String> listConsumer(String topic);

    Collection<Pair<String, Integer>> listConsumerOffset(String topic, String consumerName);

    CreateTopicsResult createTopics(List<NewTopic> newTopics);
}
