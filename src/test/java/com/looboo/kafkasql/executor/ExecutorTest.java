package com.looboo.kafkasql.executor;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExecutorTest {

    private static SqlExecutor executor = SqlExecutor.getInstance();

    @AfterClass
    public static void stopExecutor() {
        executor.stop();
    }

    @Test
    public void test_sql_executor() {
        executor.addRequest(() -> {
            System.out.println("hello");
            return null;
        }, (error, result) -> {
            System.out.println("on completion.");
        });
    }
}
