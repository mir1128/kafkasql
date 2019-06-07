package com.looboo.kafkasql.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.errors.TopicExistsException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.StreamSupport;

@Slf4j
public class KafkaUtilTest {

    private static KafkaConsumerConfig kafkaConsumerConfig;
    private static KafkaUtil kafkaUtil;

    @BeforeClass
    public static void startKafkaServer() {
        deleteTargetDir();

        KafkaMockServer.getInstance().prepare();

        String kafkaServerUrl = KafkaMockServer.getInstance().getKafkaServerUrl();
        Map<String, String> config = new HashMap<>();
        config.put("bootstrap.servers", kafkaServerUrl);

        kafkaConsumerConfig = new KafkaConsumerConfig(config);
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

    @Test
    public void test_list_topic() throws ExecutionException, InterruptedException {

        List<NewTopic> newTopics = Arrays.asList(new NewTopic("test-topic-1", 1, (short) 1),
                new NewTopic("test-topic-2", 1, (short) 1));

        CreateTopicsResult topics = null;
        try {
            kafkaUtil.getAdminClient().createTopics(newTopics).all().get();
        } catch (TopicExistsException e) {
            log.info("before list topics ");
        }

        log.info("before list topics ");
        StreamSupport.stream(kafkaUtil.listTopics().spliterator(), false).forEach(s -> log.info(s));
        log.info("after list topics");
    }
}
