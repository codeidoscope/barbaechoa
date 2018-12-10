package com.github.codeidoscope;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);

        Server server = new Server();
        server.start(portNumber);
    }

    public void start(int portNumber) {
        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.println(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }

    public interface SocketWrapper {
        void newConnection(int port);

        String getInput();

        void sendOutput(String message);

        void close();
    }

    public class MySocketWrapper implements SocketWrapper {
        private ServerSocket ss;
        private Socket s;
        InputStream inputStream;
        OutputStream outputStream;

        @Override
        public void newConnection(int port) {
            try {
                ss = new ServerSocket(port);
                s = ss.accept();
                inputStream = s.getInputStream();
                outputStream = s.getOutputStream();
            } catch (IOException e) {
                throw new RuntimeException();
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
        public void close() {
            try {
                inputStream.close();
                outputStream.close();
                s.close();
                ss.close();
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }
    }

    public class MockSocketWrapper implements SocketWrapper {

        private final PrintWriter output;
        private final BufferedReader input;

        public MockSocketWrapper(PrintWriter output, BufferedReader input) {
            this.output = output;
            this.input = input;
        }

        @Override
        public void newConnection(int port) {

        }

        @Override
        public String getInput() {
            try {
                return input.readLine();
            } catch (IOException e) {
                return "";
            }
        }

        @Override
        public void sendOutput(String message) {

        }

        @Override
        public void close() {

        }
    }
}
