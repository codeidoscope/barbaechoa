package com.github.codeidoscope;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class HelloWorldTest {
    @Test
     void testHelloWorld() {
        HelloWorld helloWorld = new HelloWorld();

        assertEquals("hello world", helloWorld.helloWorld());
    }
}
