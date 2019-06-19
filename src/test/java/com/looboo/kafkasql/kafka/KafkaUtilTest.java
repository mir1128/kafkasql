package com.looboo.kafkasql.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.ConsumerGroupDescription;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@Slf4j
public class KafkaUtilTest extends KafkaTestBase {

    @Test
    public void test_list_topic() {

        String topic1 = "test-topic-1";
        String topic2 = "test-topic-2";

        Set<String> topics = StreamSupport.stream(kafkaUtil.listTopics().spliterator(), false).collect(Collectors.toSet());

        Assert.assertTrue(topics.size() == 3);
        Assert.assertTrue(topics.contains(topic1));
        Assert.assertTrue(topics.contains(topic2));

    }

    @Test
    public void test_list_consumer_group() {
        Consumer consumer1 = new KafkaConsumer(kafkaConsumerConfig.getConsumerProperties());
        Properties properties = kafkaConsumerConfig.getConsumerProperties();
        properties.setProperty("group.id", "testgroup");
        Consumer consumer2 = new KafkaConsumer(properties);
        consumer1.subscribe(Arrays.asList("test-topic-2"));
        consumer2.subscribe(Arrays.asList("test-topic-2"));
        consumer1.poll(Duration.ofMillis(1000));
        consumer2.poll(Duration.ofMillis(1000));

        assertThat(kafkaUtil.listConsumerGroups().size(), is(2));
        assertThat(kafkaUtil.listConsumerGroups(Arrays.asList("testgroup")).size(), is(1));

        consumer1.close();
        consumer2.close();
    }
}
