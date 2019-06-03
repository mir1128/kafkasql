package com.looboo.kafkasql.kafka;

import kafka.server.KafkaConfig;
import kafka.server.KafkaServerStartable;

import java.io.IOException;
import java.util.Properties;

public class KafkaLocal {
    private KafkaServerStartable kafka;
    private Thread zookeeperThread;

    public KafkaLocal(Properties kafkaProperties, Properties zkProperties) throws IOException, InterruptedException{
        KafkaConfig kafkaConfig = new KafkaConfig(kafkaProperties);

        //start local zookeeper
        System.out.println("starting local zookeeper...");
        zookeeperThread = new ZooKeeperLocal(zkProperties).beginZookeeperThread();
        System.out.println("done");

        //start local kafka broker
        kafka = new KafkaServerStartable(kafkaConfig);
        System.out.println("starting local kafka broker...");
        kafka.startup();
        System.out.println("done");
    }


    public void stop(){
        zookeeperThread.interrupt();
        //stop kafka broker
        System.out.println("stopping kafka...");
        kafka.shutdown();
        System.out.println("done");
    }
}
