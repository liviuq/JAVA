package app;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server
{
    // Define the port on which the server is listening
    public static final int PORT = 8100;
    boolean running = true;
    public Server() throws IOException {
        ServerSocket serverSocket = null ;

        //creating a scanner to read the bit in the file "running"
        Scanner readRunning = new Scanner(new File("running"));
        try {
            serverSocket = new ServerSocket(PORT);
            while (running) {
                System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                new ClientThread(socket, this).run();
            }
        } catch (IOException e) {
            System.err. println ("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }

    public void setRunning(boolean running)
    {
        this.running = running;
    }
    public static void main ( String [] args ) throws IOException {
        Server server = new Server();
    }
}
