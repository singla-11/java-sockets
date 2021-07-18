package com.programming.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Server {

    private final ServerSocket server;
    private final AtomicBoolean running;

    public Server(int port) throws IOException {
        log.info("Starting server...");
        server = new ServerSocket(port);
        running = new AtomicBoolean(true);
        log.info("Server started on port: {}", port);
    }

    public Socket connection() {
        log.info("Waiting for a client connection request...");
        try {
            Socket socket = server.accept();
            log.info("Connection request accepted");
            return socket;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean isRunning() {
        return running.get();
    }

    public void shutdown() {
        try {
            server.close();
            running.set(false);
            log.info("Server shutdown succeeded");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
