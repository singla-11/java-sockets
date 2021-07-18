package com.programming.server;

import com.programming.socket.CommandLineArgumentUtil;
import java.io.IOException;
import java.net.Socket;

public class ServerManager {

    public static void main(String[] args) {
        Server server;
        try {
            server = new Server(CommandLineArgumentUtil.serverPort());
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }

        ConnectionHandler handler = new ConnectionHandler();
        registerShutdownHook(server);

        while (server.isRunning()) {
            Socket socket = server.connection();
            if (socket != null) handler.handle(socket);
        }
    }

    private static void registerShutdownHook(Server server) {
        Runtime r = Runtime.getRuntime();
        r.addShutdownHook(new ServerShutdownHook(server));
    }
}
