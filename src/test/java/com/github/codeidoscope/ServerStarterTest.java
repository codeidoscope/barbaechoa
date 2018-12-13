package com.github.codeidoscope;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ServerStarterTest {

    private StringWriter stringWriter;
    private MockServerConnection mockServerConnection;
    private ServerStarter server;

    void setUp(String input) {
        StringReader stringReader = new StringReader(input);
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        mockServerConnection = new MockServerConnection(bufferedReader, printWriter);
        InputValidator inputValidator = new InputValidator();
        server = new ServerStarter(mockServerConnection, inputValidator);
    }

     @Test
     void testServerConnectionWasOpened() {
         setUp("off");
         server.startServer(8080);

         assertTrue(mockServerConnection.connectionWasOpened);
     }

    @Test
    void testServerReturnsPoloWhenInputIsMarco() {
        setUp("Marco");
        server.inputLoop();

        assertEquals("POLO\n", stringWriter.toString());
    }

    @Test
    void testServerReturnsEchoWhenInputIsEcho() {
        setUp("Echo");
        server.inputLoop();

        assertEquals("ECHO\n", stringWriter.toString());
    }

    @Test
    void testServerReturnsANewLineWhenInputIsNotMarcoOrEcho() {
        setUp("not marco or echo");
        server.inputLoop();

        assertEquals("\n", stringWriter.toString());
    }

    @Test
    void testServerReturnsNothingWhenInputIsNothing() {
        setUp("");
        server.inputLoop();

        assertEquals("", stringWriter.toString());
    }
 }
