package com.programming.client;

import com.programming.socket.util.SocketUtil;
import java.io.IOException;
import java.net.Socket;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {

    private Socket socket;

    public Client(String host, int port) {
        try {
            this.socket = new Socket(host, port);
            log.info("Client connected to server on host: {} and port: {}", host, port);

            if (log.isDebugEnabled()) {
                log.debug("Inet Address of remote machine: {}", socket.getInetAddress());
                log.debug("Inet Address of local machine: {}", socket.getLocalAddress());
                log.debug("Port of remote machine: {}", socket.getPort());
                log.debug("Port of local machine: {}", socket.getLocalPort());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void sendConsoleInputToServer(String breakpoint) {
        SocketUtil.sourceOutputStreamFromConsole(socket, breakpoint);
    }
}
