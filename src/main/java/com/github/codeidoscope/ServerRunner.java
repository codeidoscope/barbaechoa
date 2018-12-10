package com.github.codeidoscope;

import java.io.IOException;

public class ServerRunner {

    public static void main(String[] args) throws IOException {
        int portNumber = 8080;
        String hostAddress = "127.0.0.1";

        Runnable serverRunnable = () -> {
            Server server = new Server();
            server.start(portNumber);
        };

        Thread serverThread = new Thread(serverRunnable);
        serverThread.start();

        Client client = new Client();
        client.start(hostAddress, portNumber);
    }
}