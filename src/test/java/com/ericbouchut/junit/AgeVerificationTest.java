package com.ericbouchut.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgeVerificationTest {

    @Test
    void personIsOver18() {
        Person adult = new Person("Henri", 42);

        Assertions.assertTrue(AgeVerification.isOver18(adult));
    }

    @Test
    void personIsUnder18() {
        Person minor = new Person("Ellya", 17);

        assertFalse(AgeVerification.isOver18(minor));
    }
}