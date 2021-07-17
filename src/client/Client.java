package client;

import util.SocketUtil;

import java.io.IOException;
import java.net.Socket;

public class Client {

    private Socket socket;

    public Client(String host, int port) {
        try {
            this.socket = new Socket(host, port);
            System.out.println("Connected");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void sendConsoleInputToServer(String breakpoint) {
        SocketUtil.sourceOutputStreamFromConsole(socket, breakpoint);
    }

}
