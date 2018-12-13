package com.github.codeidoscope;

class Server {
    public static void main(String[] args) {
        ServerConnection serverConnection = new ServerConnection();
        InputValidator inputValidator = new InputValidator();
        ServerStarter serverStarter = new ServerStarter(serverConnection, inputValidator);

        inputValidator.checkArgumentLength(args);
        inputValidator.checkPortNumberIsValid(args[1]);

        int portNumber = Integer.parseInt(args[1]);
        serverStarter.startServer(portNumber);
    }
}
