package com.looboo.kafkasql.kafka;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Properties;

public class KafkaUtilTest {

    private Properties properties = new Properties();
    private KafkaUtil kafkaUtils;

    @BeforeClass
    public static void startKafkaMockServer() {
        KafkaMockServer.startKafka();
    }

    @Test
    public void test() {
    }
}
