package com.looboo.kafkasql.rest;

import com.looboo.kafkasql.kafka.KafkaTestBase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class RestServerTest extends KafkaTestBase {
    private static RestServer restServer = new RestServer();

    @BeforeClass
    public static void startServer() {
        restServer.start();
    }

    @Test
    public void star_reset_server() throws InterruptedException {
        Thread.sleep(1000*60*60);
    }

    @AfterClass
    public static void shutdown() {
        try {
            restServer.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
