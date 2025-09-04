package com.ericbouchut.io;

import java.io.PrintStream;

/**
 * Draw an ASCII art diamond pattern using stars (*).
 * It is composed of
 * <ul>
 *   <li>an upward-pointing top triangle (with <code>radius</code> lines)</li>
 *   <li>a center row</li>
 *   <li>a downward-pointing bottom triangle (with <code>radius</code> lines)</li>
 * </ul>
 *
 * Example: <code>DiamondPattern(3).draw()</code> would display a 7-rows diamond, like so:
 * 
 * <pre><code>
 *     *         \
 *    ***        |==> top triangle (3 rows)
 *   *****       /
 *  *******        ==> center row (1 row)
 *   *****       \
 *    ***         |==> bottom triangle (3 rows)
 *     *         /
 * </code></pre>
 */
public class DiamondPattern {

    /**
     *  The radius of the Diamond (center line excluded).
     *  The total number of rows is <code>2 * radius + 1</code>.
     */
    private final int radius;

    /**
     * Max number of stars in the center row
     */
    private final int maxStars;

    /**
     * @param radius the "radius" of the diamond (must be an even number)
     */
    public DiamondPattern(final int radius) {
        if (radius % 2 != 0) {
            throw new IllegalArgumentException("radius must be an even number: " + radius);
        }

        this.radius = Math.abs(radius);
        this.maxStars = nthOddNumber(radius);
    }

    /**
     * Draw a diamond of a given radius.
     */
    public void draw () {
        int n = 0;

        // Draw the top triangle and the center row
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
        new DiamondPattern(0).draw();
        new DiamondPattern(2).draw();
        new DiamondPattern(4).draw();
        new DiamondPattern(6).draw();
    }
}
