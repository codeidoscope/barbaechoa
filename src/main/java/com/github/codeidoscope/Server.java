package com.github.codeidoscope;

public class Server {

    private ServerConnectionInterface serverConnection;

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Missing port number");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[1]);

        ServerConnection serverConnection = new ServerConnection();
        Server server = new Server(serverConnection);
        server.startServer(portNumber);
    }

    public Server(ServerConnectionInterface serverConnection) {
        this.serverConnection = serverConnection;
    }

    public void startServer(int portNumber) {
        try {
            serverConnection.openConnection(portNumber);
            System.out.println("Connection made to port " + portNumber);
            String inputLine;
            while ((inputLine = serverConnection.getInput()) != null) {
                serverConnection.sendOutput(getInputAndPrepareOutput(inputLine));
            }
            serverConnection.closeConnection();
        } catch (RuntimeException e) {
            throw new RuntimeException();
        }
    }

    String getInputAndPrepareOutput(String inputLine) {

        if (inputLine.equalsIgnoreCase("MARCO")) {
            return "POLO";
        }

        if (inputLine.equalsIgnoreCase("ECHO")) {
            return "ECHO";
        }

        return "";
    }
}
