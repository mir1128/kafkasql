package com.looboo.kafkasql.assemble;

import com.looboo.kafkasql.kafka.KafkaTestBase;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class AssembleTest extends KafkaTestBase {

    @Test
    public void test_select_star_from_topic() {

        KafkaSqlDriver driver = new KafkaSqlDriver(kafkaUtil);

        driver.parsing("select * from test-topic-1");
    }

    @Test
    public void test_select_star_from_topic_where_partition_equal_0() {

        KafkaSqlDriver driver = new KafkaSqlDriver(kafkaUtil);

        driver.parsing("select * from test-topic-1 where partition = 0");
    }

    @Test
    public void test_select_star_from_topic_where_timestamp_equal_xxx() {
        KafkaSqlDriver driver = new KafkaSqlDriver(kafkaUtil);

        List<RecordMetadata> metadata = randomRecordMetadataN(4);
        String timestamps = metadata.stream()
                .map(m -> String.valueOf(m.timestamp()))
                .collect(Collectors.joining(","));


        log.info("test_select_star_from_topic_where_timestamp_equal_xxx timestamp {}", timestamps);

        driver.parsing(String.format("select * from test-topic-1 where timestamp in (%s)", timestamps));
    }

    @Test
    public void test_select_star_from_topic_where_timestamp_in_xxxx() {
        KafkaSqlDriver driver = new KafkaSqlDriver(kafkaUtil);


    }

    @Test
    public void test_select_star_from_topic_where_partition_in() {

        KafkaSqlDriver driver = new KafkaSqlDriver(kafkaUtil);

        driver.parsing("select * from test-topic-1 where partition in (0, 1) ");
    }
}
