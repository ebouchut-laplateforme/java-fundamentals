package com.ericbouchut.junit;

public class AgeVerification {

    public static boolean isOver18(Person person) {
        return person.getAge() >= 18;
    }
}
