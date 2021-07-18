package com.programming.server;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServerShutdownHook extends Thread {

    private final Server server;

    public ServerShutdownHook(Server server) {
        this.server = server;
        log.info("ShutdownHook registered of type: {}", getClass().getTypeName());
    }

    public void run() {
        server.shutdown();
    }
}
