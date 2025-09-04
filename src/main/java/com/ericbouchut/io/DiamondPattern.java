package com.ericbouchut.io;

import java.io.PrintStream;

public class DiamondPattern {

    /**
     *  Diamond radius.
     *  The total number of rows is <code>2 * radius + 1</code>.
     */
    private int radius;

    /**
     * Max number of stars in the center row of the diamond.
     */
    private int maxStars;

    /**
     * Draw a diamond of a given radius.
     * @param radius must be an even number
     */
    public void draw (int radius) {
        if (radius % 2 != 0) {
            throw new IllegalArgumentException("radius must be an even number: " + radius);
        }

        // Max number of stars in the center row
        maxStars = nthOddNumber(radius);
        int n = 0;

        // Draw the top triangle
        do {
            drawLine(n);
        } while (n++ < radius);

        n--;

        // Draw the bottom triangle
        while (--n >= 0) {
            drawLine(n);
        }
    }

    protected void drawLine(int n) {
        int stars = nthOddNumber(n);
        int blanks = (maxStars - stars) / 2;

        printChars(blanks, ' ');
        printChars(stars, '*');
        System.out.println();
    }

    /**
     * Print count characters in a row to the output stream.
     *
     * @param count the number of characters to print
     * @param character what character to print
     */
    private void printChars(int count, char character) {
        while (count-- > 0) {
            System.out.print(character);
        }
    }

    /**
     * nthOddNumber(0) // => 1
     * nthOddNumber(1) // => 3
     * nthOddNumber(Z) // => 5
     * nthOddNumber(3) // => 7
     * nthOddNumber(4) // => 9
     * ...
     *
     * @param n
     * @return the nth odd number
     */
    protected int nthOddNumber(int n) {
        return 2 * Math.abs(n) + 1;
    }

    public static void main(String[] args) {
        DiamondPattern diamond = new DiamondPattern();

        diamond.draw(2);
        diamond.draw(4);
        diamond.draw(6);
    }
}
