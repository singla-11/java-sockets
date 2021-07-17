package com.programming.server;

public class ServerShutdownHook extends Thread {

    private final Server server;

    public ServerShutdownHook(Server server) {
        this.server = server;
    }

    public void run() {
        server.shutdown();
    }
}
