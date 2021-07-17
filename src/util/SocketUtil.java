package util;

import java.io.*;
import java.net.Socket;

public class SocketUtil {

    public static void printInputStream(Socket socket, String breakpoint) {
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()))) {
            String line = "";

            // reads message from client until "Over" is sent
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
                String line = "";

                // keep reading until "Over" is input
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
