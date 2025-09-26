package com.ericbouchut.io.motionsickness;

/**
 * Classes implementing this interface
 * count the occurrences of unique symptoms read from a text file
 * and generate a text file with an ordered list of unique (deduplicated) symptoms
 * and their respective number of occurrences.
 */
public interface ISymptomCounter {

    /**
     * <ol>
     *  <li>
     *      Read a text file that contains an unordered list of symptoms (one per line).
     *      A symptom can contain spaces.
     *      The file can contain duplicate symptoms.
     *   </li>
     *   <li>
     *       Process the input file (but <b>do not modify</b> it), so that you:
     *       <ol>
     *           <li>order alphabetically the symptoms (i.e., the lines),</li>
     *           <li>remove duplicate symptoms.</li>
     *           <li>count the occurrences of each distinct symptom,</li>
     *       </ol>
     *   </li>
     *   <li>
     *       Create a new text file
     *       with an ordered list of symptoms (one per line),
     *       with duplicates removed, using this format:
     *       <pre><code>
     *           symptom = occurrences
     *        </code></pre>
     *        For instance if you found 19 occurrences of <code>high blood pressure</code>
     *        in the input file (<code>symptoms.txt</code>, you will write once:
     *       <pre><code>
     *           high blood pressure = 19
     *        </code></pre>
     *   </li>
     * </ol>
     *
     * @param inputTextFilename the filename of a text file that contains unordered list of symptoms to be read (one per line)
     * @param outputTextFile the filename of a text file where to write the list of ordered symptoms with the number of occurrences
     * @throws SymptomException ...
     *
     * @see <a href="https://www.udemy.com/course/java-fundamentals-beginners/learn/lecture/46090645#overview">Project Motion Sickness</a> on Udemy
     */
    void count(String inputTextFilename, String outputTextFile) throws SymptomException;
}
