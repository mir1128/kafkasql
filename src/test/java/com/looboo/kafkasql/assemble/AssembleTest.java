package com.looboo.kafkasql.assemble;

import com.looboo.kafkasql.kafka.KafkaTestBase;
import org.junit.Test;

public class AssembleTest extends KafkaTestBase {

    @Test
    public void test_select_star_from_topic() {

        KafkaSqlDriver driver = new KafkaSqlDriver(kafkaUtil);

        driver.parsing("select * from test-topic-1");

        producer.close();
    }

    @Test
    public void test_select_star_from_topic_where_partition_equal_0() {

        KafkaSqlDriver driver = new KafkaSqlDriver(kafkaUtil);

        driver.parsing("select * from test-topic-1 where str(key) = 'aaaa'");

        producer.close();
    }

    @Test
    public void test_select_star_from_topic_where_partition_in() {

        KafkaSqlDriver driver = new KafkaSqlDriver(kafkaUtil);

        driver.parsing("select * from test-topic-1 where partition in (0, 1) ");

        producer.close();
    }
}
