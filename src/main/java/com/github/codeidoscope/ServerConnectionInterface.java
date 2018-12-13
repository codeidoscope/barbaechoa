package com.github.codeidoscope;

public interface ServerConnectionInterface {

    void createServerSocket(int portNumber);

    void acceptSocketConnection();

    void getIOStreams();

    String getInput();

    void sendOutput(String message);

    void closeConnection();
}
