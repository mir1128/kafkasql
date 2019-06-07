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
    public void test_list_topic() throws ExecutionException, InterruptedException {

        String topic1 = "test-topic-1";
        String topic2 = "test-topic-2";

        List<NewTopic> newTopics = Arrays.asList(new NewTopic(topic1, 1, (short) 1),
                new NewTopic(topic2, 1, (short) 1));

        try {
            kafkaUtil.createTopics(newTopics).all().get();
        } catch (TopicExistsException e) {
            log.info("before list topics ");
        }

        Set<String> topics = StreamSupport.stream(kafkaUtil.listTopics().spliterator(), false).collect(Collectors.toSet());

        Assert.assertTrue(topics.size() == 2);
        Assert.assertTrue(topics.contains(topic1));
        Assert.assertTrue(topics.contains(topic2));

    }
}
