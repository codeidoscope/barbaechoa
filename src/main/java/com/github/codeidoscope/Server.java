package com.github.codeidoscope;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        if(args.length != 2){
            System.err.println("Missing port number");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[1]);

        Server server = new Server();
        server.startServer(portNumber);
    }

    private void startServer(int portNumber) {
        try (
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.println(getInputAndPrepareOutput(inputLine));
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }

    public String getInputAndPrepareOutput(String inputLine) {
        String output = "";
        String capitalisedInput = inputLine.toUpperCase();

        if(capitalisedInput.equals("MARCO")){
            output = "POLO";
        }

        if(capitalisedInput.equals("ECHO")){
            output = "ECHO";
        }

        return output;
    }
}
