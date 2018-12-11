package com.github.codeidoscope;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class ServerTest {
     @Test
     void testAServerRespondsWithPoloWentUserSendsMarco() {
         Server server = new Server();

        assertEquals("POLO", server.getInputAndPrepareOutput("MARCO"));
     }

     @Test
     void testAServerRespondsWithEchoWentUserSendsEcho() {
         Server server = new Server();

         assertEquals("ECHO", server.getInputAndPrepareOutput("ECHO"));
     }
 }
