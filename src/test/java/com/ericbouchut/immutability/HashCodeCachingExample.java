package com.ericbouchut.immutability;

public class HashCodeCachingExample {
    public static void main(String[] args) {
        String string1 = "Hello";
        String string2 = "ABCEFGHIJKLMNOPQRSTUVWXYZ0123456789ABCEFGHIJKLMNOPQRSTUVWXYZ";

        long startNanos1   = System.nanoTime();

        string1.hashCode();

        long endNanos1     = System.nanoTime();
        long elapsedNanos1 = endNanos1 - startNanos1;

        System.out.println("\"" + string1 + "\".hashCode() took " + elapsedNanos1 + " nanos.");

        long startNanos2   = System.nanoTime();

        string1.hashCode();

        long endNanos2     = System.nanoTime();
        long elapsedNanos2 = endNanos2 - startNanos2;

        System.out.println("\"" + string2 + "\".hashCode() took " + elapsedNanos2 + " nanos.");
    }

}
