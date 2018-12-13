package com.github.codeidoscope;

public class InputValidator {

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
