package com.ericbouchut;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

    @BeforeAll
    static void setUpClass() {
        // MUST be static (meaning it is a method of the HelloWorldTest class)
        // To call such a method: HelloWorldTest.setUpClass();
        System.out.println("1) setUpClass called before ALL test methods");
    }

    @AfterAll
    static void tearDownClass() {
        // MUST be static (meaning it is a method of the HelloWorldTest class)
        // To call such a method: HelloWorldTest.tearDownClass();
        System.out.println("5) tearDownClass called AFTER ALL test methods");
    }

    @BeforeEach
    void setUp() {
        // The name of the method does not matter at all, but the annotation does
        System.out.println("2) setUp() called before each test method");
    }

    @AfterEach
    void tearDown() {
        System.out.println("4) tearDown() called after each test method");
    }

    @Test
    void echoTest() {
        System.out.println("3) echo test method called");

        // Setup the variable for the test
        HelloWorld o = new HelloWorld();

        String expectedResult = "Hello World!\n";
        String actualResult   = o.echo("Hello World!");

        // Check that the echo returns the expected value: the passed-in string followed by a newline
        assertEquals(expectedResult, actualResult);
    }
}
