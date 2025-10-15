package com.ericbouchut.record;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test a class defined with the <code>record</code> keyword
 *
 * @see PersonWithRecord
 */
class PersonWithRecordTest {

    @Test
    void recordGeneratesConstructorWithAllArgumentsTest() {
        assertInstanceOf(PersonWithRecord.class,
                new PersonWithRecord("Aleijandro", 22, "alej@example.com"));
    }

    @Test
    void recordGeneratesToStringTest() {
        PersonWithRecord person = new PersonWithRecord("Aleijandro", 22, "alej@example.com");
        assertEquals("PersonWithRecord[name=Aleijandro, age=22, email=alej@example.com]", person.toString());
    }

    /**
     * Generated accessors methods are not Javabeans accessors,
     *  meaning they do not start with a <code>get</code> prefix.
     */
    @Test
    void recordAccessorsDoNotStartWithGetTest() {
        PersonWithRecord person = new PersonWithRecord("Aleijandro", 22, "alej@example.com");

        assertEquals("Aleijandro", person.name(), "name() is not a Javabeans accessor meaning it is not prefixed with get");
        assertEquals(22, person.age());
        assertEquals("alej@example.com", person.email());
    }

    @Test
    void constructorFailsWhenEmailInvalidTest() {

        assertThrows(IllegalArgumentException.class, () -> {
            new PersonWithRecord("Josh", 64, "INVALID_EMAIL");
        });
    }
}