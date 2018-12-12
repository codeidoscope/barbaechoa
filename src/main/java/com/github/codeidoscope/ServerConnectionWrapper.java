package com.github.codeidoscope;

public interface ServerConnectionWrapper {

    void openConnection(int portNumber);

    String getInput();

    void sendOutput(String message);

    void closeConnection();
}
