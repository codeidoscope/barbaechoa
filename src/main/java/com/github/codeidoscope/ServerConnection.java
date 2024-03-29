package com.github.codeidoscope;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnection implements ServerConnectionInterface {
    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;

    @Override
    public void createServerSocket(int portNumber) {
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    @Override
    public void acceptSocketConnection() {
        try {
            socket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    @Override
    public void getIOStreams() {
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    @Override
    public String getInput() {
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
        System.out.println("Closing connection - Bye! \uD83D\uDC4B");
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
