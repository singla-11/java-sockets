package com.programming.client;

import com.programming.socket.util.CommandLineArgumentUtil;
import java.io.IOException;

public class ClientManager {

    public static void main(String[] args) {
        Client client;
        try {
            client =
                    new Client(
                            CommandLineArgumentUtil.serverHost(),
                            CommandLineArgumentUtil.serverPort());
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }

        client.sendConsoleInputToServer(CommandLineArgumentUtil.endOfStreamIdentifier());
    }
}
