package com.github.codeidoscope;


import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ServerTest {

    private StringReader stringReader;
    private BufferedReader bufferedReader;
    private StringWriter stringWriter;
    PrintWriter printWriter;
    private MockServerConnection mockServerConnection;
    Server server;

    void setUp(String input) {
        stringReader = new StringReader(input);
        bufferedReader = new BufferedReader(stringReader);
        stringWriter = new StringWriter();
        printWriter = new PrintWriter(stringWriter);
        mockServerConnection = new MockServerConnection(bufferedReader, printWriter);
        server = new Server(mockServerConnection);
    }

    @Test
     void testAServerRespondsWithPoloWentUserSendsMarco() {
        setUp("");

        assertEquals("POLO", server.getInputAndPrepareOutput("MARCO"));
     }

     @Test
     void testAServerRespondsWithEchoWentUserSendsEcho() {
         setUp("");

         assertEquals("ECHO", server.getInputAndPrepareOutput("ECHO"));
     }

     @Test
     void testServerConnectionWasOpened() {
         setUp("");
         server.startServer(8080);

         assertTrue(mockServerConnection.connectionWasOpened);
     }
 }
