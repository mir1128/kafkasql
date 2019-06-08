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
}
