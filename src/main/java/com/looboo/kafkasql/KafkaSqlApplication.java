package com.looboo.kafkasql;

import com.beust.jcommander.JCommander;
import com.looboo.kafkasql.executor.FutureCallback;
import com.looboo.kafkasql.executor.SqlExecutor;
import com.looboo.kafkasql.rest.RestServer;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class KafkaSqlApplication {

    public static void main(String[] args) throws Exception {
        Arguments arguments = new Arguments();

        JCommander.newBuilder()
                .addObject(arguments)
                .build()
                .parse(args);

        if (arguments.isServerMode()) {
            RestServer restServer = new RestServer();
            restServer.start();
        } else {
            String name = arguments.brokerName();

            Map<String, String> consumerConfig = new HashMap<>();
            consumerConfig.put("bootstrap.servers", arguments.servers());
            FutureCallback<String> cb1 = new FutureCallback<>();
            SqlExecutor.getInstance().addBroker(name, consumerConfig, cb1);
            String s = cb1.get();

            if (arguments.getSql() != null && !arguments.getSql().isEmpty()) {
                FutureCallback<String> cbx = new FutureCallback<>();
                SqlExecutor.getInstance().execute(name, arguments.getSql(), cbx);
                System.out.println(cbx.get());
                System.exit(0);
            } else {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String command = reader.readLine();
                while (command.equalsIgnoreCase("exit")) {
                    FutureCallback<String> cbx = new FutureCallback<>();
                    SqlExecutor.getInstance().execute(name, command, cbx);
                    System.out.println(cbx.get());
                }
                System.exit(0);
            }
        }
    }
}
