package com.looboo.kafkasql.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class KafkaTestBase {

    protected static KafkaConsumerConfig kafkaConsumerConfig;
    protected static KafkaUtil kafkaUtil;

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
}
