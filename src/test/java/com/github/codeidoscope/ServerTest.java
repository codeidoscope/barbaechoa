package com.github.codeidoscope;


import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ServerTest {

    private StringWriter stringWriter;
    private MockServerConnection mockServerConnection;
    private ServerStarter server;
    private InputValidator inputValidator;

    void setUp(String input) {
        StringReader stringReader = new StringReader(input);
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        mockServerConnection = new MockServerConnection(bufferedReader, printWriter);
        inputValidator = new InputValidator();
        server = new ServerStarter(mockServerConnection, inputValidator);
    }

    @Test
     void testAServerRespondsWithPoloWentUserSendsMarco() {
        setUp("");

        assertEquals("POLO", inputValidator.getInputAndPrepareOutput("MARCO"));
     }

     @Test
     void testAServerRespondsWithEchoWentUserSendsEcho() {
         setUp("");

         assertEquals("ECHO", inputValidator.getInputAndPrepareOutput("ECHO"));
     }

     @Test
     void testServerConnectionWasOpened() {
         setUp("");
         server.startServer(8080);

         assertTrue(mockServerConnection.connectionWasOpened);
     }

    @Test
    void testServerReturnsPoloWhenInputIsMarco() {
        setUp("Marco");
        server.startServer(8080);

        assertEquals("POLO\n", stringWriter.toString());
    }

    @Test
    void testServerReturnsEchoWhenInputIsEcho() {
        setUp("Echo");
        server.startServer(8080);

        assertEquals("ECHO\n", stringWriter.toString());
    }

    @Test
    void testServerReturnsANewLineWhenInputIsNotMarcoOrEcho() {
        setUp("not marco or echo");
        server.startServer(8080);

        assertEquals("\n", stringWriter.toString());
    }

    @Test
    void testServerReturnsNothingWhenInputIsNothing() {
        setUp("");
        server.startServer(8080);

        assertEquals("", stringWriter.toString());
    }
 }
