package com.ericbouchut.math;

/**
 * This helper class defines 2 methods named <code>add</code>,
 * but with a <b>different</b> type of <b>return value</b>, and <b>arguments<b> of different types.
 *
 * We define two <code>add</code> methods in the same class each with a different signature.
 */
public class Calculator {
    // No need to add the default constructor as Java adds it by default when this is the only one

    /**
     * Compute the sum of the passed in arguments.
     * @param a an integer value
     * @param b an integer value
     * @return the sum of <code>a</code> and <code>b</code> as an <code>int</code> value
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Compute the sum of the passed in arguments.
     * @param a a value of type <code>double</code>
     * @param b a value of type <code>double</code>
     * @return the sum of <code>a</code> and <code>b</code> as an <code>double</code> value
     */
    public double add(double a, double b) {
        return a + b;
    }

}

