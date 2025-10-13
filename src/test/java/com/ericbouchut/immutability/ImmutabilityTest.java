package com.ericbouchut.immutability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ImmutabilityTest {

    public static boolean isInStringPool(String string) {
        return string == string.intern();
    }

    /**
     * Test a String built with the constructor, that is the new instance operator: <code>new String(...)</code>.
     */
    @Test
    void testNewStringConstructor() {
        String s1 = new String("Hello");
        String s2 = new String("Hello");

        assertTrue(s1 != s2, "Identical Strings built with the new instance operator have DIFFERENT memory ADDRESSES");

        assertFalse(isInStringPool(s1), "A String built with the new instance operator (constructor) is NOT in the String Pool by default");
        s1.intern();
        assertTrue(isInStringPool(s1));

        assertEquals("Hello", s1);
        assertEquals("Hello", s2);


        assertNotEquals("hello", s1.intern(), "The Pool representation (interned string) and the original String have the SAME CASE");
    }

    /**
     * Test a String build with string literal.
     * A string literal is a set of characters enclosed in double quotes: <code>"like so"</code>.
     */
    @Test
    void testNewStringLiteral() {
        String s1 = "Hello";
        String s2 = "Hello";

        assertEquals("Hello", s1);
        assertEquals("Hello", s2);
        assertTrue(s1.equals(s2));

        assertTrue(s1 == s2, "Strings built with the SAME STRING LITERAL share the SAME ADDRESS");

        assertTrue("Hello" == s1.intern(), "The Pool representation (interned string) and the original String share the SAME ADRESS");
        assertEquals("Hello", s1.intern(), "The Pool representation (interned string) and the original String have the SAME CASE");
        assertEquals("Hello", s2.intern());
    }
}
