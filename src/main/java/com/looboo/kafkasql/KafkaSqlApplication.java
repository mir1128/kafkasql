package com.looboo.kafkasql;

import com.looboo.kafkasql.assemble.KafkaSqlDriver;
import com.looboo.kafkasql.kafka.KafkaConsumerConfig;
import com.looboo.kafkasql.kafka.KafkaUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class KafkaSqlApplication {

	public static void main(String[] args) {
		KafkaUtil kafkaUtil = new KafkaUtil(new KafkaConsumerConfig(new HashMap<>()));
		KafkaSqlDriver driver = new KafkaSqlDriver(kafkaUtil);
		driver.parsing("select * from test-topic-1");
	}

}
