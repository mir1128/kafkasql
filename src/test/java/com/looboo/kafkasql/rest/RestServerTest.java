package com.looboo.kafkasql.rest;

import com.looboo.kafkasql.executor.FutureCallback;
import com.looboo.kafkasql.executor.SqlExecutor;
import com.looboo.kafkasql.kafka.KafkaMockServer;
import com.looboo.kafkasql.kafka.KafkaTestBase;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class RestServerTest extends KafkaTestBase {
    private static RestServer restServer = new RestServer();

    @BeforeClass
    public static void startServer() throws ExecutionException, InterruptedException {
        restServer.start();

        String kafkaServerUrl = KafkaMockServer.getInstance().getKafkaServerUrl();
        Map<String, String> consumerConfig = new HashMap<>();
        consumerConfig.put("bootstrap.servers", kafkaServerUrl);

        FutureCallback<String> cb = new FutureCallback<>();
        SqlExecutor.getInstance().addBroker("test-borker", consumerConfig, cb);
        String s = cb.get();
        Assert.assertEquals(s, "created");
    }

    @Test
    public void star_reset_server() throws InterruptedException {

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
