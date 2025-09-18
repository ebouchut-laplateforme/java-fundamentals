package com.ericbouchut;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {
    HelloWorld o = new HelloWorld();

    @BeforeEach
    void setUp() {
        System.out.println("setUp() called");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown() called");
    }

    @Test
    void echo() {
        assertEquals("Hello World!XXX", o.echo("Hello World!"));
    }
}