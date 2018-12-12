package com.github.codeidoscope;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnection implements ServerConnectionWrapper {
    private ServerSocket serverSocket;
    private Socket socket;
    InputStream inputStream;
    OutputStream outputStream;
    private int portNumber;

    @Override
    public void openConnection(int portNumber) {
        this.portNumber = portNumber;
        try {
            serverSocket = new ServerSocket(portNumber);
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public String getInput() {
        System.out.println("Connection made to port " + portNumber);
        try {
            return new BufferedReader(new InputStreamReader(inputStream)).readLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void sendOutput(String message) {
        new PrintWriter(outputStream, true).println(message);
    }

    @Override
    public void closeConnection() {
        try {
            inputStream.close();
            outputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
