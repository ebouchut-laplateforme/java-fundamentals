package com.ericbouchut.controlstructure;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.IntStream;

/**
 * Helper class to dabble with for loops in Java.
 */
public class ForLoop {

    public static void main(String[] args) {
        ForLoop forLoop = new ForLoop();

        forLoop.splitThousandSledgeHammer();
    }

    public void oneMilionPoneys() {
        for (int i= 1; i <= 1_000_000; i++)  {
            System.out.println("Poney " + i);
        }
    }

    public void splitThousandPrimitive() {
        for (int i= 1; i <= 1_000; i++) {
            if (i == 500) {
                System.out.println("==> We are half way there. Hold on!");
            }
            System.out.println(i);
        }
    }

    public void splitThousandSledgeHammer() {
        int [] thousandValues = buildtIntArrayThousandValues();

        Spliterator.OfInt spliterator = Arrays.spliterator(thousandValues);

        // This one will iterate over the fisrst half: [1..500]
        Spliterator.OfInt firstHalfIterator = spliterator.trySplit();

        // After `spliterator.trySplit()`, spliterator will iterate over the rest, i.e., the second half: [501..1000]

        // Display the first hallf (i.e., 1 up to 500)
        firstHalfIterator.forEachRemaining((int i) -> System.out.println(i));

        System.out.println("We are half way there! Hold on.");

        // Display the second hallf (i.e., 501 up to 1_000)
        spliterator.forEachRemaining((int i) -> System.out.println(i));
    }

    /**
     * @return an int array populated with values from 1 (inclusive) to one thousand (inclusive).
     */
    public int[] buildtIntArrayThousandValues() {
        return IntStream.rangeClosed(1, 1_000).toArray();
    }

}
