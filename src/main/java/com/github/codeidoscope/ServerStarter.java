package com.github.codeidoscope;

class ServerStarter {
    private ServerConnectionInterface serverConnection;
    private InputValidator inputValidator;
    private boolean serverShouldContinueRunning = true;

    ServerStarter(ServerConnectionInterface serverConnection, InputValidator inputValidator) {
        this.serverConnection = serverConnection;
        this.inputValidator = inputValidator;
    }

    void startServer(int portNumber) {
        System.out.println("Connection made to port " + portNumber);
        serverConnection.createServerSocket(portNumber);
        do {
            serverConnection.acceptSocketConnection();
            serverConnection.getIOStreams();
            try {
                inputLoop();
            } catch (RuntimeException e) {
                throw new RuntimeException();
            }
        } while (serverShouldContinueRunning);
        serverConnection.closeConnection();
    }

    void inputLoop() {
        String inputLine;
        while ((inputLine = serverConnection.getInput()) != null) {
            if (inputLine.equalsIgnoreCase("off")) {
                serverShouldContinueRunning = false;
            }
            serverConnection.sendOutput(inputValidator.getInputAndPrepareOutput(inputLine));
        }
    }
}
