package com.looboo.kafkasql;

import com.beust.jcommander.Parameter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Arguments {

    @Parameter(names = {"--bootstrap-servers", "-b"}, description = "broker list")
    private List<String> bootstrapServers;

    @Parameter(names = "--broker-name", description = "broker name")
    private String name;

    @Parameter(names = "--sql", description = "sql to execute.")
    private String sql;

    @Parameter(names = {"--help", "-h"}, description = "help")
    private boolean help;

    @Parameter(names = "--server-mode", description = "server mode")
    private boolean serverMode = false;

    public String servers() {
        if (bootstrapServers == null || bootstrapServers.isEmpty()) {
            return "127.0.0.1:9092";
        } else {
            return bootstrapServers.stream().collect(Collectors.joining(","));
        }
    }

    public String brokerName() {
        Random random = new Random();
        if (name == null) {
            return "broker_" + random.nextLong();
        } else {
            return name;
        }
    }
}
