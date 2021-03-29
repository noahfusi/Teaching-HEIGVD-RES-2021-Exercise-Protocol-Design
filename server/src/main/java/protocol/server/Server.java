package protocol.server;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class Server
{
    private static final int port = 9999;
    public void start()
    {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        PrintWriter os = null;
        BufferedReader is = null;
        try{
            serverSocket = new ServerSocket(port);
            while(true)
            {
                clientSocket = serverSocket.accept();
                is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                os = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())));
                os.println("Welcome to the CALC");
                os.flush();
                /*
                is.close();
                os.close();
                clientSocket.close();*/

            }
        }
        catch (Exception e)
        {

        }

    }

    public static void main( String[] args )
    {
        Server server = new Server();
        server.start();
    }
}
