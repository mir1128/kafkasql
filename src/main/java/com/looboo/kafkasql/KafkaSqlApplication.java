package com.looboo.kafkasql;

import com.beust.jcommander.JCommander;
import com.looboo.kafkasql.executor.FutureCallback;
import com.looboo.kafkasql.executor.SqlExecutor;
import com.looboo.kafkasql.rest.RestServer;
import jline.console.ConsoleReader;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class KafkaSqlApplication {
    private static String prompts = "KafkaSql:>";

    public static void main(String[] args) throws Exception {
        Arguments arguments = new Arguments();

        JCommander commander = JCommander.newBuilder()
                .addObject(arguments)
                .build();
        commander.parse(args);

        if (arguments.isHelp()) {
            commander.usage();
        } else if (arguments.isServerMode()) {
            RestServer restServer = new RestServer();
            System.out.println("start kafka sql rest server. listening on " + restServer.advertisedUrl());
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

                ConsoleReader reader = new ConsoleReader();
                reader.setPrompt(prompts);

                String command = reader.readLine();
                while (command != null && !command.equalsIgnoreCase("exit")) {
                    FutureCallback<String> cbx = new FutureCallback<>();
                    SqlExecutor.getInstance().execute(name, command, cbx);
                    System.out.println(cbx.get());
                    System.out.print(prompts);
                    command = reader.readLine();
                }
                System.exit(0);
            }
        }
    }
}
