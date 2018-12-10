package com.github.codeidoscope;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class HelloWorldTest {
    @Test
     void testHelloWorld() {
        ServerRunner helloWorld = new ServerRunner();

        assertEquals("hello marion", helloWorld.helloWorld("marion"));
    }
}
