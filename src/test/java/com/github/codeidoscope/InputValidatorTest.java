package com.github.codeidoscope;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void testAServerRespondsWithPoloWentUserSendsMarco() {
        InputValidator inputValidator = new InputValidator();


        assertEquals("POLO", inputValidator.getInputAndPrepareOutput("MARCO"));
    }

    @Test
    void testAServerRespondsWithEchoWentUserSendsEcho() {
        InputValidator inputValidator = new InputValidator();

        assertEquals("ECHO", inputValidator.getInputAndPrepareOutput("ECHO"));
    }
}