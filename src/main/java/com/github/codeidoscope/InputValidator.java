package com.github.codeidoscope;

class InputValidator {

    void checkArgumentLength(String[] arguments){
        if (arguments.length != 2) {
            System.err.println("Missing port number");
            System.exit(1);
        }
    }

    void checkPortNumberIsValid(String portNumberInput) {
        try {
            Integer.parseInt(portNumberInput);
        } catch (NumberFormatException e) {
            System.err.println("Incorrect port number. Please try again");
            System.exit(1);
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
