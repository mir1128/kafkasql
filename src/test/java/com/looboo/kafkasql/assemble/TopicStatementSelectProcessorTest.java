package com.looboo.kafkasql.assemble;

import com.looboo.kafkasql.kafka.KafkaTestBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TopicStatementSelectProcessorTest extends KafkaTestBase {

    @Test
    public void test_select_topics() {
        KafkaSqlDriver driver = new KafkaSqlDriver(kafkaUtil);
        driver.parsing("select topics");
    }
}
