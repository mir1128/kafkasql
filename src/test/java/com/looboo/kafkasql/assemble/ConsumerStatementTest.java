package com.looboo.kafkasql.assemble;


import com.looboo.kafkasql.kafka.KafkaTestBase;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerStatementTest extends KafkaTestBase {

    @Test
    public void test_select_consumer_from_group() {

        Properties properties = kafkaConsumerConfig.getConsumerProperties();
        properties.setProperty("group.id", "testgroup");
        Consumer consumer = new KafkaConsumer(properties);
        consumer.subscribe(Arrays.asList("test-topic-2"));
        consumer.poll(Duration.ofMillis(1000));

        KafkaSqlDriver driver = new KafkaSqlDriver(kafkaUtil);

        driver.parsing("select consumers (testgroup)");

        consumer.close();
    }

    @Test
    public void test_select_all_group() {

        KafkaSqlDriver driver = new KafkaSqlDriver(kafkaUtil);
        Consumer consumer1 = new KafkaConsumer(kafkaConsumerConfig.getConsumerProperties());
        Properties properties = kafkaConsumerConfig.getConsumerProperties();
        properties.setProperty("group.id", "testgroup");
        Consumer consumer2 = new KafkaConsumer(properties);
        consumer1.subscribe(Arrays.asList("test-topic-2"));
        consumer2.subscribe(Arrays.asList("test-topic-2"));
        consumer1.poll(Duration.ofMillis(1000));
        consumer2.poll(Duration.ofMillis(1000));

        driver.parsing("select consumers(*)");

        consumer1.close();
        consumer2.close();
    }
}