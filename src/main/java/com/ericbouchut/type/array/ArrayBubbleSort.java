package com.ericbouchut.type.array;

/**
 * Ex 49:
 * This helper class provides a {@link #sort(int[])} method to sort an array using the <b>bubble sort</b> method.
 * O(N<sup>2</sup>) (Quadratic complexity_).
 *
 * @see <a href="https://www.udemy.com/course/java-fundamentals-beginners/learn/lecture/46065461#overview">Java Fundamentals Course on Udemy</a>
 */
public class ArrayBubbleSort {

    /**
     * Sort the passed-in integer array using the bubble sort method.
     *
     * @param array the integer array to sort
     */
    public static void sort(int[] array) {
        new ArrayBubbleSort().bubbleSort(array);
    }

    /**
     * Sort the passed in integer array using the bubble sort method.
     * This method modifies the passed in array.
     *
     * @param array an int array
     */
    public void bubbleSort(int[] array) {
        boolean isSorted = false;
        int buffer;

        for (int i=0; i < array.length; i++) {

            for (int j=0; j < array.length && j+1 < array.length; j++) {
                isSorted = array[j] <= array[j+1];

                if (!isSorted) {
                    // Swap the 2 consecutive array items to sort them in ascending order
                    buffer     = array[j];
                    array[j]   = array[j+1];
                    array[j+1] = buffer;
                }
            }
        }
        System.out.println(isSorted);
    }

    /**
     * Display the passed-in array on the standard output.
     *
     * @param array an integer array
     */
    public void display(int[] array) {
        for(int item: array) {
            System.out.printf("%d ", item);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayBubbleSort ex49 = new ArrayBubbleSort();

        // Build an integer array filled with random values [1..10]
        int[] numbers = RandomValuesArrayBuilder.build(10, 10);
        ex49.display(numbers);

        ex49.bubbleSort(numbers);
        ex49.display(numbers);
    }
}
