package com.programming.socket;

import java.io.*;
import java.net.Socket;

public class SocketUtil {

    private static final String EMPTY_STRING = "";

    public static void printInputStream(Socket socket, String breakpoint) {
        try (DataInputStream in =
                new DataInputStream(new BufferedInputStream(socket.getInputStream()))) {
            String line = EMPTY_STRING;

            while (!line.equals(breakpoint)) {
                try {
                    line = in.readUTF();
                    System.out.println(line);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void sourceOutputStreamFromConsole(Socket socket, String breakpoint) {
        try (DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
                String line = EMPTY_STRING;

                while (!line.equals(breakpoint)) {
                    line = input.readLine();
                    out.writeUTF(line);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
