
package com.github.codeidoscope;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MockServerConnection implements ServerConnectionInterface {
    private final BufferedReader input;
    private final PrintWriter output;
    public boolean connectionWasOpened = false;

    public MockServerConnection(BufferedReader input, PrintWriter output) {
        this.output = output;
        this.input = input;
    }

    @Override
    public void openConnection(int portNumber) {
        connectionWasOpened = true;
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
