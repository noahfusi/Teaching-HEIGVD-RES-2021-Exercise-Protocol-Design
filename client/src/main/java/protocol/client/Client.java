package protocol.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Hello world!
 *
 */
public class Client
{
    Socket clientSocket;
    BufferedReader socketIn = null;
    PrintWriter socketOut = null;
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public void connect()
    {
        try {
            clientSocket = new Socket("192.168.1.133", 9999);
            socketIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            socketOut =  new PrintWriter(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())));
            System.out.println("Connection succesful");
            String input;
            while((input = socketIn.readLine()) != null)
            {
                System.out.println(input);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main( String[] args )
    {
        Client client = new Client();
        client.connect();
    }
}
