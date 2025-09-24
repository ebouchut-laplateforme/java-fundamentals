package com.ericbouchut.io.motionsickness;

/**
 * <code>SymptomException</code> is raised when something goes wrong
 * while reading, processing the symptoms file,
 * or writing the output file with the symptoms and their number of occurrence.
 */
public class SymptomException extends Exception {
    @java.io.Serial
    private static final long serialVersionUID = 1L;

    public SymptomException(String message) {
        super(message);
    }

    public SymptomException(String message, Throwable cause) {
        super(message, cause);
    }

}
