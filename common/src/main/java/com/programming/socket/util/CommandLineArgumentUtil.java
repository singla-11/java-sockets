package com.programming.socket.util;

public class CommandLineArgumentUtil {

    private static final String HOST = "host";
    private static final String PORT = "port";
    private static final String END_OF_STREAM_IDENTIFIER = "eos";

    public static String serverHost() {
        return System.getProperty(HOST);
    }

    public static int serverPort() {
        return Integer.parseInt(System.getProperty(CommandLineArgumentUtil.PORT));
    }

    public static String endOfStreamIdentifier() {
        return System.getProperty(END_OF_STREAM_IDENTIFIER);
    }
}
