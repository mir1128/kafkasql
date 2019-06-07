package com.looboo.kafkasql.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class KafkaTestBase {

    protected static KafkaConsumerConfig kafkaConsumerConfig;
    protected static KafkaProducerConfig kafkaProducerConfig;
    protected static KafkaUtil kafkaUtil;
    protected static KafkaProducer producer;

    @BeforeClass
    public static void startKafkaServer() {
        deleteTargetDir();

        KafkaMockServer.getInstance().prepare();

        String kafkaServerUrl = KafkaMockServer.getInstance().getKafkaServerUrl();
        Map<String, String> consumerConfig = new HashMap<>();
        consumerConfig.put("bootstrap.servers", kafkaServerUrl);

        kafkaConsumerConfig = new KafkaConsumerConfig(consumerConfig);

        Map<String, String> producerConfig = new HashMap<>();
        producerConfig.put("bootstrap.servers", kafkaServerUrl);
        kafkaProducerConfig = new KafkaProducerConfig(producerConfig);
        producer = new KafkaProducer(kafkaProducerConfig.getProducerProperties());

        kafkaUtil = new KafkaUtil(kafkaConsumerConfig);
    }

    @AfterClass
    public static void stopKafkaServer() throws IOException {
        KafkaMockServer.getInstance().tearDown();
    }

    private static void deleteTargetDir() {
        String targetDir = "target";
        int i = 0;
        while (i++ < 3) {
            try {
                FileUtils.deleteDirectory(new File(targetDir));
            } catch (IOException e) {
                log.info(e.getLocalizedMessage());
            }
            File targetFileDir = new File(targetDir);
            if (!targetFileDir.exists()) {
                break;
            }
        }
    }
}
