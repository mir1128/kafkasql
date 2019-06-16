package com.looboo.kafkasql.rest;

import org.junit.BeforeClass;
import org.junit.Test;

public class RestServerTest {

    @BeforeClass
    public static void startServer() {
        RestServer restServer = new RestServer();
        restServer.start();
    }

    @Test
    public void name() throws InterruptedException {
        Thread.sleep(1000*60*60);
    }
}
