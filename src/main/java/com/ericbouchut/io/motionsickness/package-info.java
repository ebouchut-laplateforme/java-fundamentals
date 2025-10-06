/**
 * The Motion Sickness lab is a practice on <b>how to read, process, and write text files</b>.
 *
 * <p>Here is the <b>exercise statement</b>:
 *
 * <p>A text file (<a href="https://github.com/ebouchut-laplateforme/java-fundamentals/blob/main/src/main/resources/symptoms.txt">{@code symptoms.txt}</a>) contains an <b>unordered list of symptoms</b>.
 * There is <b>one</b> symptom <b>per line</b>.
 * A symptom can contain <b>spaces</b>.
 * The file can contain <b>duplicate</b> symptoms.
 *
 * <ul>
 *     <li>Read the input file</li>
 *     <li>Process the input file (but <b>do not modify</b> it) in order to:</li>
 *     <ul>
 *         <li>Order alphabetically the symptoms (i.e., the lines),</li>
 *          <li>Remove duplicate symptoms,</li>
 *          <li>Count the occurrences of each distinct symptom.</li>
 *     </ul>
 *     <li>Create a new text file ({@code results.txt})</li>
 *     <ul>
 *       <li>With an ordered list of unique symptoms (one per line),</li>
 *       <li>With duplicates removed,</li>
 *       <li>Using this format: {@code symptom = occurrences}</li>
 *     </ul>
 * </ul>
 *
 * <p>
 *  For instance if you found 11 occurrences of the {@code high blood pressure} symptom in the input file, the output file should contain:
 *  <pre>{@code
 *  high blood pressure = 11
 *  }</pre>
 *
 * <p>Here is what the output file ({@code results.txt}) should look like:
 *
 * <pre>{@code
 * anxiety = 7
 * arrhythmias = 4
 * blindness = 2
 * blurred vision = 6
 * constricted pupils = 3
 * cough = 7
 * dialated pupils = 4
 * dizziness = 6
 * dry mouth = 10
 * fever = 9
 * headache = 4
 * high blood pressure = 11
 * inflamation = 9
 * insomnia = 4
 * low blood pressure = 4
 * nausea = 7
 * rapid heart rate = 1
 * rash = 6
 * shortness of breath = 4
 * stiff neck = 6
 * stomach pain = 5
 * tremor = 4
 * water retention = 1
 * }</pre>
 *
 * @see <a href="https://www.udemy.com/course/java-fundamentals-beginners/learn/lecture/46090645#overview">Udemy course</a> for details
 * @author Eric Bouchut
 */
package com.ericbouchut.io.motionsickness;

import java.lang.annotation.Documented;