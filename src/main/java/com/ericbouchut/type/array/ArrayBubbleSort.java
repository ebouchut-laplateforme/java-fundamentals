package com.ericbouchut.type.array;

/**
 * Ex 49:
 * This helper class provides a {@link #sort(int[])} method to sort an array using the <b>bubble sort</b> method.
 * O(N<sup>2</sup>) (Quadratic complexity_).
 *
 * @see <a href="https://www.udemy.com/course/java-fundamentals-beginners/learn/lecture/46065461#overview">Java Fundamentals Course on Udemy</a>
 * TODO: Make bubbleSort(int[]) and display(int[] static then make the class final
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
     * Sort the passed in integer array (in ascending order) using the bubble sort method.
     * This method modifies the passed in array.
     *
     * @param array an int array
     */
    public void bubbleSort(int[] array) {
        int     loopCount = 0;
        boolean isSorted = false;

        for (int i=0; !isSorted && i < array.length; i++) {

            // array.length - 1:     Disregard the last item as it is already sorted
            // array.length - 1 - i: Do not re-sort items that have already been sorted
            for (int j=0; j <  array.length - 1 - i; j++) {
                loopCount++;
                isSorted = array[j] <= array[j+1];

                if (!isSorted) {
                    // Swap the 2 consecutive array items to sort them in ascending order
                    int temp   = array[j];
                    array[j]   = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.printf("loopCount = %d\n", loopCount);
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

        // Build an integer array filled with 10 random values [1..10]
        int[] numbers = RandomValuesArrayBuilder.build(10, 10);
        ex49.display(numbers);

        ex49.bubbleSort(numbers);
        ex49.display(numbers);
    }
}
