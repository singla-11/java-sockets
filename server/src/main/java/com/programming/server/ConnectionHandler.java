package com.programming.server;

import com.programming.socket.util.CommandLineArgumentUtil;
import com.programming.socket.util.SocketUtil;
import java.io.IOException;
import java.net.Socket;

public class ConnectionHandler {

    public void handle(Socket socket) {
        SocketUtil.printInputStream(socket, CommandLineArgumentUtil.endOfStreamIdentifier());
        try {
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
