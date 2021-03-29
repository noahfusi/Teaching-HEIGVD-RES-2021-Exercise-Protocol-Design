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
    private static final String[] supportedCommands = new String[]{"HELP", "ADD", "SUB", "MULT", "DIV", "CLOSE"};

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
                os.println("Enter HELP for the list of commands");
                os.println("Enter CLOSE to end the communication");
                os.println("END");
                os.flush();
                while(true)
                {
                    String command = is.readLine();
                    if(command.length() != 0)
                    {
                        String[] args = command.split(" ");
                        os.println(processCommands(args));
                        os.flush();
                    }
                    else
                    {

                    }
                }
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

    public static String processCommands(String[] args)
    {
        String command = args[0];
        String answer = "";
        switch(command)
        {
            case "HELP":
            {
                answer = "Here are the commands : HELP";
                break;
            }
            default:
            {
                answer = "Unknown command";
                break;
            }
        }
        return answer;
    }

    public static void main( String[] args )
    {
        Server server = new Server();
        server.start();
    }
}
