package com.looboo.kafkasql;

import com.looboo.kafkasql.kafka.KafkaUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class KafkaUtilTest {

    private Properties properties = new Properties();
    private KafkaUtil kafkaUtils;

    @Before
    public void prepare() {
//        properties.put("bootstrap.servers", "localhost:9092");
//        properties.put("auto.offset.reset", "earliest");
//        properties.put("key.converter", "org.apache.kafka.connect.converters.ByteArrayConverter");
//        properties.put("value.converter", "org.apache.kafka.connect.converters.ByteArrayConverter");
//        properties.put("enable.auto.commit", "false");
//        properties.put("key.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
//        properties.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
//        properties.put("max.poll.records", "500");
//        properties.put("group.id", "kafkasql");
//        properties.put("request.timeout.ms", "2000");
//
//        kafkaUtils = new KafkaUtil(properties);
    }

    @Test
    public void name() throws ExecutionException, InterruptedException, TimeoutException {
//
//        ListTopicsOptions listTopicsOptions = new ListTopicsOptions()
//                .listInternal(true)
//                .timeoutMs(2000);
//        Set<String> retrievedTopicSet = kafkaUtils.getAdminClient()
//                .listTopics(listTopicsOptions).names()
//                .get(2000, TimeUnit.MILLISECONDS);
//
//        System.out.println(retrievedTopicSet);
    }
}
