package com.github.codeidoscope;

class Server {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Missing port number");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[1]);

        ServerConnection serverConnection = new ServerConnection();
        InputValidator inputValidator = new InputValidator();
        ServerStarter serverStarter = new ServerStarter(serverConnection, inputValidator);
        serverStarter.startServer(portNumber);
    }
}
