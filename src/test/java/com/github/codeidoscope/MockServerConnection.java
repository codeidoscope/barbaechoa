
package com.github.codeidoscope;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MockServerConnection implements ServerConnectionInterface {
    private final BufferedReader input;
    private final PrintWriter output;
    boolean connectionWasOpened = false;

    MockServerConnection(BufferedReader input, PrintWriter output) {
        this.output = output;
        this.input = input;
    }

    @Override
    public void createServerSocket(int portNumber) {

    }

    @Override
    public void acceptSocketConnection() {
        connectionWasOpened = true;
    }

    @Override
    public void getIOStreams() {

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
        output.println(message);
    }

    @Override
    public void closeConnection() {
    }
}
