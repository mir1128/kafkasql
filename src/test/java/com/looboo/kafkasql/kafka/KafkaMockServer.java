package com.looboo.kafkasql.kafka;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Random;

@Slf4j
public class KafkaMockServer {

    private static KafkaMockServer instance = new KafkaMockServer();

    private Random randPortGen = new Random(System.currentTimeMillis());
    private KafkaLocal kafkaServer;
    private String hostname = "localhost";
    private int kafkaLocalPort;
    private int zkLocalPort;
    Properties kafkaProperties = new Properties();
    Properties zkProperties = new Properties();

    private KafkaMockServer() {
        init();
    }

    public static KafkaMockServer getInstance() {
        return instance;
    }

    private void init(){
        try {
            hostname = InetAddress.getLocalHost().getHostName();
            zkProperties.load(Class.class.getResourceAsStream("/zookeeper.properties"));
            kafkaProperties.load(Class.class.getResourceAsStream("/kafka-server.properties"));

        } catch (UnknownHostException e) {
            log.info("Error getting the value of localhost. Proceeding with 'localhost'.");
        } catch (IOException e) {
            log.info("load properties failed.");
        }
    }

    private boolean startKafkaServer() {
        try {
            ZooKeeperLocal zookeeper;
            while (true) {
                try {
                    zkLocalPort = getNextPort();

                    zkProperties.setProperty("clientPort", Integer.toString(zkLocalPort));
                    zookeeper = new ZooKeeperLocal(zkProperties);
                    break;
                } catch (BindException bindEx) {
                }
            }
            log.info("ZooKeeper instance is successfully started on port " + zkLocalPort);

            // override the Zookeeper url.
            kafkaProperties.setProperty("zookeeper.connect", getZkUrl());
            while (true) {
                kafkaLocalPort = getNextPort();
                // override the Kafka server port
                kafkaProperties.setProperty("port", Integer.toString(kafkaLocalPort));
                kafkaServer = new KafkaLocal(kafkaProperties);
                try {
                    kafkaServer.start();
                    break;
                } catch (BindException bindEx) {
                    // let's try another port.
                }
            }
            log.info("Kafka Server is successfully started on port " + kafkaLocalPort);
            return true;

        } catch (Exception e) {
            log.info("Error starting the Kafka Server." + e.getLocalizedMessage());
            return false;
        }
    }

    public void prepare() {
        boolean startStatus = startKafkaServer();
        if (!startStatus) {
            throw new RuntimeException("Error starting the server!");
        }
        try {
            Thread.sleep(3 * 1000);   // add this sleep time to
            // ensure that the server is fully started before proceeding with tests.
        } catch (InterruptedException e) {
            // ignore
        }
        log.info("Completed the prepare phase.");
    }

    public void tearDown() {
        log.info("Shutting down the kafka Server.");
        kafkaServer.stop();
        log.info("Completed the tearDown phase.");
    }

    private synchronized int getNextPort() {
        // generate a random port number between 49152 and 65535
        return randPortGen.nextInt(65535 - 49152) + 49152;
    }

    public String getZkUrl(){
        return hostname + ":" + zkLocalPort;
    }

    public String getKafkaServerUrl(){
        return hostname + ":" + kafkaLocalPort;
    }

    public String getKafkaLogDir() {
        return kafkaProperties.getProperty("log.dirs");
    }
}
