package com.programming.socket.util;

import java.io.*;
import java.net.Socket;

public class SocketUtil {

    public static void printInputStream(Socket socket, String breakpoint) {
        try (DataInputStream in =
                new DataInputStream(new BufferedInputStream(socket.getInputStream()))) {

            String line;
            try {
                do {
                    line = in.readUTF();
                    System.out.println(line);
                } while (!line.equals(breakpoint));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void sourceOutputStreamFromConsole(Socket socket, String breakpoint) {
        try (DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {
            try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {

                String line;
                do {
                    line = input.readLine();
                    out.writeUTF(line);
                } while (!line.equals(breakpoint));

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
