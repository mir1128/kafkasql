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

        RecordMetadata recordMetadata = randomRecordMetadata();

        log.info("test_select_star_from_topic_where_timestamp_equal_xxx timestamp {}", recordMetadata.timestamp());

        driver.parsing(String.format("select * from test-topic-1 where timestamp = %s", recordMetadata.timestamp()));
    }

    @Test
    public void test_select_star_from_topic_where_timestamp_in_xxxx() {
        KafkaSqlDriver driver = new KafkaSqlDriver(kafkaUtil);

        List<RecordMetadata> metadata = randomRecordMetadataN(4);
        String timestamps = metadata.stream()
                .map(m -> String.valueOf(m.timestamp()))
                .collect(Collectors.joining(","));

        log.info("test_select_star_from_topic_where_timestamp_equal_xxx timestamp = {}", timestamps);

        driver.parsing(String.format("select * from test-topic-1 where timestamp in (%s)", timestamps));
    }

    @Test
    public void test_select_star_from_topic_where_partition_in() {

        KafkaSqlDriver driver = new KafkaSqlDriver(kafkaUtil);

        driver.parsing("select * from test-topic-1 where partition in (0, 1) ");
    }

    @Test
    public void test_select_star_from_topic_where_str_key_equal_xxxx() {
        KafkaSqlDriver driver = new KafkaSqlDriver(kafkaUtil);

        driver.parsing(String.format("select * from test-topic-1 where str(key) =  '1'"));
    }

    @Test
    public void test_select_star_from_topic_where_str_key_in_xxxx() {
        KafkaSqlDriver driver = new KafkaSqlDriver(kafkaUtil);

        driver.parsing(String.format("select * from test-topic-1 where str(key) in ('1', '2', '3')"));
    }

    @Test
    public void test_select_star_from_topic_where_timestamp_between_xxx_and_xxx() {
        KafkaSqlDriver driver = new KafkaSqlDriver(kafkaUtil);

        List<RecordMetadata> metadata = randomRecordMetadataN(2);

        long from = Math.min(metadata.get(0).timestamp(), metadata.get(1).timestamp());
        long to = Math.max(metadata.get(0).timestamp(), metadata.get(1).timestamp());

        log.info("test_select_star_from_topic_where_timestamp_between_xxx_and_xxx timestamp between {} and {}", from, to);

        driver.parsing(String.format("select * from test-topic-1 where timestamp between (%s, %s)", from, to));
    }

    @Test
    public void test_select_star_from_topic_where_partition_between_xxx_and_xxx() {
        KafkaSqlDriver driver = new KafkaSqlDriver(kafkaUtil);

        driver.parsing(String.format("select * from test-topic-1 where partition between (0, 1)"));
    }
}
