package com.looboo.kafkasql.assemble;

import com.looboo.kafkasql.kafka.KafkaTestBase;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AssembleTest extends KafkaTestBase {

    @Test
    public void test_select_star_from_topic() throws ExecutionException, InterruptedException {

        String topicName = "test-topic-1";
        NewTopic newTopic = new NewTopic(topicName, 3, (short)1);
        kafkaUtil.createTopics(Arrays.asList(newTopic)).all().get();

        for (int i = 0; i < 100; ++i) {
            Future<RecordMetadata> send = producer.send(new ProducerRecord(topicName, Integer.toString(i), Integer.toString(i)));
            send.get();
        }

        KafkaSqlDriver driver = new KafkaSqlDriver(kafkaUtil);

        driver.parsing("select * from test-topic-1");

        producer.close();
    }
}
