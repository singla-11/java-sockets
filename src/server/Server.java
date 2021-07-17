package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

public class Server {

    private final ServerSocket server;
    private final AtomicBoolean running;

    public Server(int port) throws IOException {
        server = new ServerSocket(port);
        running = new AtomicBoolean(true);
        System.out.println("Server started");
    }

    public Socket connection() {
        System.out.println("Waiting for a client...");
        try {
            Socket socket = server.accept();
            System.out.println("Connection request accepted");
            return socket;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean isRunning() {
        return running.get();
    }

    public void shutdown() {
        try {
            server.close();
            running.set(false);
            System.out.println("Server shutdown succeeded");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

