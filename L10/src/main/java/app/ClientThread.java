package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread
{
    private Socket socket = null ;
    private Server server = null;
    public ClientThread(Socket socket, Server server) { this.socket = socket ;  this.server = server;}
    public void run () {
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();
            // Send the response to the oputput stream: server → client
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String raspuns = "Hello " + request + "!";
            if(request.compareTo("quit") == 0)
            {
                server.setRunning(false);
            }
            out.println(raspuns);
            out.flush();
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }
}
