package com.looboo.kafkasql.kafka;

import kafka.server.KafkaConfig;
import kafka.server.KafkaServer;
import kafka.server.KafkaServerStartable;

import java.io.IOException;
import java.util.Properties;

public class KafkaLocal {

    private KafkaConfig kafkaConfig;
    private Properties kafkaProperties;
    private Properties zookeeperConfig;

    private KafkaServerStartable kafka;
    private ZooKeeperLocal zookeeper;

    public KafkaLocal(Properties kafkaProperties, Properties zkProperties) {
        this.kafkaProperties = kafkaProperties;
        this.kafkaConfig = new KafkaConfig(kafkaProperties);
        this.zookeeperConfig = zkProperties;
    }

    public void startZookeeper() {
        //start local zookeeper
        System.out.println("starting local zookeeper...");
        try {
            zookeeper = new ZooKeeperLocal(zookeeperConfig);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }

    public void startKafka() {
        //start local kafka broker
        KafkaServer server = new KafkaServer(kafkaConfig, null, null, null);
        System.out.println("starting local kafka broker...");
        try {
            server.startup();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }


    public void stop(){
        //stop kafka broker
        System.out.println("stopping kafka...");
        kafka.shutdown();
        System.out.println("done");
    }
}
