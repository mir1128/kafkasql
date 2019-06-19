package com.looboo.kafkasql.kafka;

import com.looboo.kafkasql.assemble.LeaderTopicPartition;
import org.antlr.v4.runtime.misc.Pair;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ConsumerGroupDescription;
import org.apache.kafka.clients.admin.ConsumerGroupListing;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class KafkaUtil implements IKafkaUtil {

    private AdminClient adminClient;
    private Consumer consumer;

    public KafkaUtil(KafkaConsumerConfig kafkaConsumerConfig) {
        adminClient = AdminClient.create(kafkaConsumerConfig.getAdminClientProperties());
        consumer = new KafkaConsumer(kafkaConsumerConfig.getConsumerProperties());
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
        try {
            return getLeaderTopicPartitions(topic).stream()
                    .map(topicPartition -> topicPartition.partition())
                    .collect(Collectors.toSet());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return new HashSet<>();
    }

    @Override
    public Map<TopicPartition, List<ConsumerRecord>> poll(String topic) {
        Map<TopicPartition, Long> offset = getOffset(topic);
        return poll(topic, offset);
    }

    public Map<TopicPartition, List<ConsumerRecord>> poll(String topic, Map<TopicPartition, Long> partitionLongMap) {
        consumer.assign(partitionLongMap.keySet());
        consumer.seekToBeginning(partitionLongMap.keySet());

        Map<TopicPartition, List<ConsumerRecord>> result = new HashMap<>();

        boolean finished = false;
        while (!finished) {
            ConsumerRecords consumerRecords = consumer.poll(Duration.ofMillis(1000));

            Stream<ConsumerRecord> stream = StreamSupport.stream(consumerRecords.spliterator(), false);
            Map<TopicPartition, List<ConsumerRecord>> collect = stream.collect(Collectors.groupingBy(record -> new TopicPartition(record.topic(), record.partition())));

            result = Stream.concat(result.entrySet().stream(), collect.entrySet().stream())
                    .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (v1, v2) -> {
                        v1.addAll(v2);
                        return v1;
                    }));

            finished = isFinished(result, partitionLongMap);
        }
        return result;
    }

    private boolean isFinished(Map<TopicPartition, List<ConsumerRecord>> result, Map<TopicPartition, Long> partitionLongMap) {
        return result.keySet().stream().allMatch(k -> {
            List<ConsumerRecord> records = result.get(k);
            return records.get(records.size() - 1).offset() >= partitionLongMap.get(k) - 1;
        });
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
    public Map<TopicPartition, Long> getOffset(String topic) {
        try {
            Set<TopicPartition> topicPartitions = getLeaderTopicPartitions(topic);
            return consumer.endOffsets(topicPartitions);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }


    @Override
    public Map<TopicPartition, Long> getOffset(String topic, List<Integer> partitions) {
        try {
            Set<TopicPartition> topicPartitionsSet = getLeaderTopicPartitions(topic).stream()
                    .filter(t -> partitions.contains(t.partition()))
                    .collect(Collectors.toSet());

            if (topicPartitionsSet.isEmpty()) {
                return Collections.emptyMap();
            }

            return consumer.endOffsets(topicPartitionsSet);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    @Override
    public Collection<Integer> getPartitions(String topic) {
        return null;
    }

    @Override
    public Map<String, ConsumerGroupDescription> listConsumerGroups() {
        try {
            Collection<String> groupIdList = adminClient.listConsumerGroups().all().get()
                .stream().map(ConsumerGroupListing::groupId).collect(Collectors.toList());
            return adminClient.describeConsumerGroups(groupIdList).all().get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    @Override
    public Map<String, ConsumerGroupDescription> listConsumerGroups(List<String> groups) {
        try {
            Collection<String> groupIdList = adminClient.listConsumerGroups().all().get()
                .stream().map(ConsumerGroupListing::groupId)
                .filter(groupId -> groups.contains(groupId.toUpperCase())).collect(Collectors.toList());

            return adminClient.describeConsumerGroups(groupIdList).all().get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    @Override
    public Collection<Pair<String, Integer>> listConsumerOffset(String topic, String consumerName) {
        return null;
    }

    @Override
    public CreateTopicsResult createTopics(List<NewTopic> newTopics) {
        return adminClient.createTopics(newTopics);
    }

    private Set<TopicPartition> getLeaderTopicPartitions(String topic) throws InterruptedException, ExecutionException {
        Map<String, TopicDescription> descriptionMap;
        try {
            descriptionMap = adminClient.describeTopics(Collections.singleton(topic)).all().get();
        } catch (Exception e) {
            return Collections.emptySet();
        }

        Set<LeaderTopicPartition> leaderTopicPartitions = descriptionMap.values().stream()
                .map(topicDescription -> topicDescription.partitions().stream()
                        .map(p -> new LeaderTopicPartition(p.leader().id(), topicDescription.name(), p.partition())))
                .flatMap(Function.identity()).collect(Collectors.toSet());

        return leaderTopicPartitions.stream()
                .map(leaderTopicPartition -> leaderTopicPartition.toTopicPartition()).collect(Collectors.toSet());
    }

}
