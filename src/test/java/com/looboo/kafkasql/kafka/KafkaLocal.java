package com.looboo.kafkasql.kafka;

import kafka.server.KafkaConfig;
import kafka.server.KafkaServer;
import kafka.server.KafkaServerStartable;

import java.io.IOException;
import java.util.Properties;

public class KafkaLocal {

    public KafkaServerStartable kafka;
    public ZooKeeperLocal zookeeper;

    public KafkaLocal(Properties kafkaProperties) throws IOException, InterruptedException{
        KafkaConfig kafkaConfig = new KafkaConfig(kafkaProperties);

        //start local kafka broker
        kafka = new KafkaServerStartable(kafkaConfig);
    }

    public void start() throws Exception{
        kafka.startup();
    }

    public void stop(){
        kafka.shutdown();
    }
}
