package ru.ddev;


import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.ResourceFactory;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

import java.util.List;

class JettyServer {

    private Server server;

    void start() throws Exception {

        Server server = getServer();

        // Create and configure a ResourceHandler.
        ResourceHandler handler = getResourceHandler();

        // Create a ContextHandler with contextPath.
        ContextHandler context = new ContextHandler(handler, "/pages");

        // Link the context to the server.
        server.setHandler(context);

        server.start();

    }

    private static ResourceHandler getResourceHandler() {
        ResourceHandler handler = new ResourceHandler();
        // Configure the directory where static resources are located.
        handler.setBaseResource(ResourceFactory.of(handler).newResource("src/main/resources/"));
        // Configure directory listing.
        handler.setDirAllowed(false);
        // Configure welcome files.
        handler.setWelcomeFiles(List.of("index.html"));
        // Configure whether to accept range requests.
        handler.setAcceptRanges(true);
        return handler;
    }

    private static Server getServer() {
        int maxThreads = 100;
        int minThreads = 10;
        int idleTimeout = 120;

        // Create and configure a ThreadPool.
        QueuedThreadPool threadPool = new QueuedThreadPool(maxThreads, minThreads, idleTimeout);
        threadPool.setName("server");

        Server server = new Server(threadPool);

        ServerConnector connector = getServerConnector(server);

        server.addConnector(connector);
        return server;
    }

    private static ServerConnector getServerConnector(Server server) {
        // The number of acceptor threads.
        int acceptors = 1;

        // The number of selectors.
        int selectors = 1;

        // Create a ServerConnector instance.
        ServerConnector connector = new ServerConnector(server, acceptors, selectors, new HttpConnectionFactory());

        // Configure TCP/IP parameters.
        // The port to listen to.
        connector.setPort(8080);
        // The address to bind to.
        connector.setHost("127.0.0.1");

        // The TCP accept queue size.
        connector.setAcceptQueueSize(128);
        return connector;
    }

    void stop() throws Exception {
        server.stop();
    }




}