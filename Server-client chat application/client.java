import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 12345);
            System.out.println("Connected to server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String serverMessage, clientMessage;

            while (true) {
                System.out.print("You: ");
                clientMessage = consoleReader.readLine();
                out.println(clientMessage);

                if (clientMessage.equalsIgnoreCase("bye")) {
                    System.out.println("Disconnected from server.");
                    break;
                }

                serverMessage = in.readLine();
                System.out.println("Server: " + serverMessage);
            }

            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
