package com.programming.client;

import com.programming.socket.CommandLineArgument;
import com.programming.socket.Contract;

public class ClientManager {

    public static void main(String[] args) {
        Client client =
                new Client(
                        System.getProperty(CommandLineArgument.HOST),
                        Integer.parseInt(System.getProperty(CommandLineArgument.PORT)));
        client.sendConsoleInputToServer(Contract.breakpoint());
    }
}
