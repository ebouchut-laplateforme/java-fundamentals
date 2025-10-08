package com.ericbouchut.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CalculatorTest {
    void foo() {
        System.out.println("Method not executed, because not annotated with @Test");
    }

    @Test
    void addSumsTwoArguments() {
        assertEquals(12, new Calculator().add(5, 7));
        assertNotEquals(0, new Calculator().add(5, 7));
    }
}
