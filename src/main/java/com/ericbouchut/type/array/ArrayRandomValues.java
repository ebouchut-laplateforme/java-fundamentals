package com.ericbouchut.type.array;

import java.util.Random;

/**
 * Exercise 46:
 * Fill an array with random values.
 * Each value is generated with the roll of a die.
 *
 * The main method builds an array with 501 random values whose value is between 1 and 10.
 *
 * @see https://www.udemy.com/course/java-fundamentals-beginners/learn/lecture/46065385#overview
 */
public class ArrayRandomValues {
    /**
     * The default number of times we roll the dice.
     */
    public static final int DICE_ROLLS = 501;

    /**
     * The default number of faces of the die.
     * Our dice has 10 faces by default [1..10] (inclusive).
     */
    public static final int FACE_COUNT = 10;


    /**
     * Build an array populated with <code>diceRolls</code> random values generated
     * with a die with <code>diceFaces</code> faces.
     * Each array item will have a value between 1 (inclusive) and <code>diceFaces</code> (inclusive) that is [1 - diceFaces].
     * <pre><code>
     *     .rollDice(501, 10); // return an integer array with 501 items whose value is a random number between 1 (inclusive) and 10 (inclusive).
     * </code></pre>
     * @param diceRolls the number of times we roll the dice, that is the number of random values, and the size of the generated array.
     * @param diceFaces the number of faces of the dice used to generate the random values for an array item [1..<code>diceFaces</code>].
     *
     * @return an integer array populated with random values generated with a <code>diceFaces</code>-faces die, i.e. [1, <code>dieFaces</code>].
     */
    public int[] rollDice(int diceRolls, int diceFaces) {
        int[] array = new int[diceRolls];
        Random random = new Random();

        for(int i=0; i < diceRolls; i++) {
            array[i] = random.nextInt(diceFaces) + 1;
        }
        return array;
    }

    /**
     * Count the number of occurences of an integer in an array.
     *
     * @param values an array of integer values
     * @param searchedValue the integer value we need to count the occurrences of
     * @return the number of occurences of <code>searchedValue</code> in the integer array <code>values</code>
     */
    public int countOccurrences(int[] values, int searchedValue) {
        int occurences = 0;

        for(int value: values) {
            if (value == searchedValue) {
                occurences++;
            }
        }
        return occurences;
    }

    public void displayArray(int [] array) {
        for(int i=0; i < array.length; i++) {
            System.out.printf("[%d]: %d\n", i, array[i]);
        }
    }
    public static void main(String[] args) {
        ArrayRandomValues ex46 = new ArrayRandomValues();

        // Build an array of 501 integers whose value is a random number [1, 10]
        int[] randomValues = ex46.rollDice(501, 10);

        ex46.displayArray(randomValues);
        System.out.printf("Found %d occurences of %d\n", ex46.countOccurrences(randomValues, 10), 10);
    }
}
