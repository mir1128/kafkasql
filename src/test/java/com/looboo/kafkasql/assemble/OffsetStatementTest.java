package com.looboo.kafkasql.assemble;

import com.looboo.kafkasql.kafka.KafkaTestBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


//select offsets(topic);
//select offsets(topic.1);


@Slf4j
public class OffsetStatementTest extends KafkaTestBase {

    @Test
    public void test_select_star_from_topic() {

        KafkaSqlDriver driver = new KafkaSqlDriver(kafkaUtil);

        driver.parsing("select offsets(test-topic-1)");
    }
}
