package com.looboo.kafkasql.kafka;

import org.apache.zookeeper.server.ServerConfig;
import org.apache.zookeeper.server.ZooKeeperServerMain;
import org.apache.zookeeper.server.quorum.QuorumPeerConfig;

import java.io.IOException;
import java.util.Properties;

public class ZooKeeperLocal {
    private ZooKeeperServerMain zooKeeperServer;
    private ServerConfig configuration = new ServerConfig();

    public ZooKeeperLocal(Properties zkProperties) {
        QuorumPeerConfig quorumConfiguration = new QuorumPeerConfig();
        try {
            quorumConfiguration.parseProperties(zkProperties);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        zooKeeperServer = new ZooKeeperServerMain();
        configuration.readFrom(quorumConfiguration);
    }

    public Thread beginZookeeperThread() {
        Thread zookeeperThread = new Thread(() -> {
            try {
                zooKeeperServer.runFromConfig(configuration);
            } catch (IOException e) {
                System.out.println("ZooKeeper Failed");
                e.printStackTrace(System.err);
            }
        });
        zookeeperThread.start();
        return zookeeperThread;
    }
}
