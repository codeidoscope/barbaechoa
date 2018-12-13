package com.github.codeidoscope;

public interface ServerConnectionInterface {

    void openConnection(int portNumber);

    String getInput();

    void sendOutput(String message);

    void closeConnection();
}
