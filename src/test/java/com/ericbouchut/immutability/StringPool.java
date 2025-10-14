package com.ericbouchut.immutability;

public class StringPool
{
    public static void main(String[] args) {
        poolVersusHeap();
    }

    private static void poolVersusHeap() {
        // Goes to the String Pool
        String stringPool1 = "Hello";

        // Reuses the same reference from the Pool
        String stringPool2 = "Hello";

        // Creates a new String in Heap
        String stringHeap  = new String("Hello");

        // Returns the reference from Pool
        String stringPool4 = stringHeap.intern();

        System.out.println(stringPool1 == stringPool2); // ==> true  (same reference)
        System.out.println(stringPool1 == stringHeap);  // ==> false (different objects)
        System.out.println(stringPool1 == stringPool4); // ==> true  (both from the Pool)
    }
}
