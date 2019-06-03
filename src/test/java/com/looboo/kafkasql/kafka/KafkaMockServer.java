package com.looboo.kafkasql.kafka;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.fail;

public class KafkaMockServer {
    static KafkaLocal kafka;

    @BeforeClass
    public static void startKafka(){
        Properties kafkaProperties = new Properties();
        Properties zkProperties = new Properties();

        try {
            //load properties
            kafkaProperties.load(Class.class.getResourceAsStream("/kafkalocal.properties"));
            zkProperties.load(Class.class.getResourceAsStream("/zklocal.properties"));

            //start kafka
            kafka = new KafkaLocal(kafkaProperties, zkProperties);
            Thread.sleep(5000);
        } catch (Exception e){
            e.printStackTrace(System.out);
            fail("Error running local Kafka broker");
            e.printStackTrace(System.out);
        }

        //do other things
    }

    @Test
    public void testSomething() {

    }

}
