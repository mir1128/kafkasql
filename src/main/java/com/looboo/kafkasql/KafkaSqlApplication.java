package com.looboo.kafkasql;

import com.looboo.kafkasql.assemble.KafkaSqlDriver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KafkaSqlApplication {

	public static void main(String[] args) {
		KafkaSqlDriver driver = new KafkaSqlDriver();
		driver.parsing("select * from test-topic-1");
	}

}
