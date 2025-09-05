package com.ericbouchut.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Helper class that generates pseudorandom numbers (<code>Integer</code>)
 * whose value is between 0 (inclusive) and an upper bound (inclusive).
 * It uses either {@link Random#nextInt(int)} or {@link Math#random()}.
 *
 * @see java.util.Random
 * @see java.lang.Math
 */
public class Randomizer {
    private final Random random;

    public Randomizer() {
        this.random = new Random();
    }

    /**
     * Generate a list of pseudorandom integers from 0 (inclusive) up to <code>upperBound</code> (inclusive).
     *
     * @param upperBound the upper bound (including)
     * @param numberCount the number of integers
     * @return <code>numberCount</code> pseudo random integers with a value greater or equal to zero, and lower or equal to <code>upperBound</code>t (</code>[0, upperBound]<code>)
     */
    public List<Integer> randomInts(int upperBound, int numberCount) {
        List<Integer> randoms = new ArrayList<>(numberCount);

        while (numberCount-- > 0) {
            randoms.add( randomIntMath(upperBound));
        }
        return randoms;
    }

    /**
     * @param upperBound the upper bound (included)
     * @return a pseudorandom integer between 0 and <code>upperBound</code> (inclusive).
     */
    public int randomInt(int upperBound) {
        return random.nextInt(upperBound + 1);
    }

    /**
     * @param upperBound the maximum value for the generated pseudorandom integer
     * @return a pseudorandom integer between 0 (inclusive) and <code>upperBound</code> (inclusive).
     */
    public int randomIntMath(int upperBound) {
        double randomDouble = Math.random();

        return (int) Math.round(randomDouble * upperBound);
    }

    public static void main(String[] args) {
        Randomizer randomizer = new Randomizer();

        System.out.println(randomizer.randomInts(6, 10));
    }
}
