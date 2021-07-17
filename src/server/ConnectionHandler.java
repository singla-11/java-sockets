package server;

import util.Contract;
import util.SocketUtil;

import java.io.IOException;
import java.net.Socket;

public class ConnectionHandler {

    public void handle(Socket socket) {
        SocketUtil.printInputStream(socket, Contract.breakpoint());
        try {
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
