package com.looboo.kafkasql;

import com.looboo.kafkasql.assemble.KafkaSqlDriver;

public class KafkaSqlApplication {

	public static void main(String[] args) {
		KafkaSqlDriver driver = new KafkaSqlDriver();
		driver.parsing("select * from test-topic-1");
	}

}
