package com.ericbouchut.lang;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <code>happycoders.eu/java</code> is an <b>excellent source</b> to learn Java.
 * I use it to discover the <a href="https://www.happycoders.eu/java/java-25-features/">new features in each Java version</a>.
 *
 * @see <a href="https://www.happycoders.eu/java/text-blocks/">New Text Block feature available since Java 15</a>
 */
@DisplayName("Multiline String")
public class MultilineStringTest {

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @Nested
    @DisplayName("Before Java 15, without Text Block")
    class BeforeJava15 {

        @Test
        @DisplayName("Use String concatenation to create multiline Strings")
        void multilineStringBeforeJava15WithStringConcatenation() {
            String multilineString = "{\n"
                    + "A,\n"
                    + "B,\n"
                    + "C\n"
                    + "}";

            assertEquals("{\nA,\nB,\nC\n}", multilineString.toString());
        }
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @Nested
    @DisplayName("Since Java 15, with Text Block")
    class SinceJava15 {

        @Test
        @DisplayName("Use Text Block to create multiline Strings (keep newlines)")
        void multilineStringSinceJava15WithTextBlock() {
            String multilineString = """
                    A,
                    B,
                    C""";

            assertEquals("A,\nB,\nC", multilineString);
        }

        @Test
        @DisplayName("Text Block trim right spaces by default")
        void textBlockTrimRightSpacesByDefault() {
            // Note: line 1 ends with 1 space, line 2 ends with 2 spaces, line 3 ends with 3 spaces
            String multilineString = """
                      line 1 
                      line 2     
                      line 3   """;

            assertEquals("line 1\nline 2\nline 3", multilineString);
        }

        @Test
        @DisplayName("Use \\ at the end of a line to disable newline")
        void multilineStringDisableNewline() {
            String multilineString = """
                    A,\
                    B,\
                    C""";

            assertEquals("A,B,C", multilineString);
        }

        @Test
        @DisplayName("Use \\s (instead of the rightmost space) to prevent Text Block from right trimming spaces")
        void preventTextBlockFromRightTrimmingSpaces() {
            String multilineString = """
                      1\s
                      2 \s
                      3  \s""";

            // TODO: Not realy testing Text Block here!
            // This gives a useful visual clue, but maybe a bit overkill and way out of the scope of this Unit test.
            String multilineStringWithVisualizedSpaces = multilineString
                    // ==> "1 \n2  \n3   "
                    // Split the string into multiple lines using the newline as a delimiter,
                    // then build a Stream of Strings with each line to the Stream pipeline
                    .lines()
                    // ==> {"1 ", "2  ", "3   "}
                    // enclose with pipes and replace spaces with dots: "2  " => "|2..|"
                    .map(line -> "|" + line.replace(' ', '.') + "|")
                    // ==> {"|1.|", "|2..|", "|3...|"}
                    // Join all the items in the stream together into a single string, adding newlines between them.
                    .collect(Collectors.joining("\n"));

            assertEquals("1 \n2  \n3   ",       multilineString);
            assertEquals("|1.|\n|2..|\n|3...|", multilineStringWithVisualizedSpaces);
        }
    }
}
