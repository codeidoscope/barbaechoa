package com.github.codeidoscope;

public class ServerStarter {
    private ServerConnectionInterface serverConnection;
    private InputValidator inputValidator;

    public ServerStarter(ServerConnectionInterface serverConnection, InputValidator inputValidator) {
        this.serverConnection = serverConnection;
        this.inputValidator = inputValidator;
    }

    public void startServer(int portNumber) {
        try {
            serverConnection.openConnection(portNumber);
            System.out.println("Connection made to port " + portNumber);
            String inputLine;
            while ((inputLine = serverConnection.getInput()) != null) {
                serverConnection.sendOutput(inputValidator.getInputAndPrepareOutput(inputLine));
            }
            serverConnection.closeConnection();
        } catch (RuntimeException e) {
            throw new RuntimeException();
        }
    }
}
