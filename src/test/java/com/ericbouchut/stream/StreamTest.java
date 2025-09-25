package com.ericbouchut.stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamTest {

    @Test
    void of() {

    }
    @Test
     void count() {
        Stream<Integer> people = Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(10L, people.count());
    }
}
