package com.programming.client;

import com.programming.socket.CommandLineArgumentUtil;

public class ClientManager {

    public static void main(String[] args) {
        Client client =
                new Client(
                        CommandLineArgumentUtil.serverHost(), CommandLineArgumentUtil.serverPort());
        client.sendConsoleInputToServer(CommandLineArgumentUtil.endOfStreamIdentifier());
    }
}
