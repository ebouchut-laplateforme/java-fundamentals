package com.ericbouchut.type.array;

import java.util.Random;

/**
 * Exercise 46:
 * Helper class to build an integer filled with random values
 * generated with the roll of a die.
 *
 * @see <a href="https://www.udemy.com/course/java-fundamentals-beginners/learn/lecture/46065385#overview">Java Fundamentals Course on Udemy</a>
 */
public class RandomValuesArrayBuilder {

    /**
     * This method delegates to {@link #rollDice(int, int)}
     * See this method for complete documentation (parameters and return value).
     *
     * @see RandomValuesArrayBuilder#rollDice(int, int)
     */
    public static int[] build(int arraySize, int maxRandomValue) {
        return new RandomValuesArrayBuilder().rollDice(arraySize, maxRandomValue);
    }

    /**
     * Count the number of occurences of an integer in an array.
     *
     * @param values an array of integer values
     * @param searchedValue the integer value we need to count the occurrences of
     * @return the number of occurences of <code>searchedValue</code> in the integer array <code>values</code>
     */
    public static int countOccurrences(int[] values, int searchedValue) {
        int occurences = 0;

        for(int value: values) {
            if (value == searchedValue) {
                occurences++;
            }
        }
        return occurences;
    }

    /**
     * Display each array item on a line,
     * using this format: <code>[ArrayItemIndex]: ArrayItemValue</code>.
     *
     * @param array the integer array to display
     */
    public static void displayArray(int [] array) {
        for(int i=0; i < array.length; i++) {
            System.out.printf("[%d]: %d\n", i, array[i]);
        }
    }

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
     * Build an array with 501 random values (between 1 and 10).
     * Display the array using {@link #displayArray(int[])}.
     * Then display the number of occurrences of <code>10</code> in the array.
     *
     * @param args a String array with the java command line arguments
     */
    public static void main(String[] args) {
        // Build an array of 501 integers whose value is a random number [1, 10]
        int[] randomValues = RandomValuesArrayBuilder.build(501, 10);

        RandomValuesArrayBuilder.displayArray(randomValues);

        int tenOccurrenceCount = RandomValuesArrayBuilder.countOccurrences(randomValues, 10);
        System.out.printf("Found %d occurences of %d\n", tenOccurrenceCount, 10);
    }
}
