package com.looboo.kafkasql.assemble;

import com.looboo.kafkasql.kafka.KafkaTestBase;
import org.junit.Test;

public class CountStatementTest extends KafkaTestBase {

    @Test
    public void test_select_count_from_topic_partition() {

        KafkaSqlDriver driver = new KafkaSqlDriver(kafkaUtil);

        driver.parsing("select count(test-topic-1.1)");
    }
}
