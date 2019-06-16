package com.looboo.kafkasql.rest;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

@Slf4j
public class RestServer {
    private static final String PROTOCOL_HTTP = "http";
    private static final String HOSTNAME = "127.0.0.1";
    private static final int PORT = 12306;

    private Server jettyServer;

    public RestServer() {
        this.jettyServer = new Server(PORT);
    }

    public void start() {
        log.info("start rest server");

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        jettyServer.setHandler(context);

        ServletHolder servletHolder = context.addServlet(ServletContainer.class, "/*");
        servletHolder.setInitOrder(0);
        servletHolder.setInitParameter(
                "jersey.config.server.provider.packages",
                "com.looboo.kafkasql.rest.resources");

        try {
            jettyServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("REST server listening at " + jettyServer.getURI() + ", advertising URL " + advertisedUrl());
    }

    private Connector createConnector() {
        ServerConnector connector = new ServerConnector(jettyServer);
        connector.setName(String.format("%s_%s%d", PROTOCOL_HTTP, HOSTNAME, PORT));
        connector.setHost(HOSTNAME);
        connector.setPort(PORT);
        return connector;
    }

    public void stop() {

    }

    public URI advertisedUrl() {
        UriBuilder builder = UriBuilder.fromUri(jettyServer.getURI());

        ServerConnector connector = (ServerConnector) jettyServer.getConnectors()[0];
        builder.port(connector.getPort());

        log.info("Advertised URI: {}", builder.build());

        return builder.build();
    }


}
