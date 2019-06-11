package com.looboo.kafkasql.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.errors.TopicExistsException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
}
