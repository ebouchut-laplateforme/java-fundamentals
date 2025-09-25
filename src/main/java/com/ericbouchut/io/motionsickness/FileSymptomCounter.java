package com.ericbouchut.io.motionsickness;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class FileSymptomCounter implements ISymptomReader, ISymptomProcessor, ISymptomWriter, ISymptomCounter {

    /**
     * {@inheritDoc}
     *
     * @param inputFilename the filename where to find the symptoms
     * @param outputFilename
     * @throws SymptomException when something goes wrong while opening, reading or writing the files.
     */
    @Override
    public void count(String inputFilename, String outputFilename) throws SymptomException {
        BufferedReader reader = read(inputFilename);
        Map<String, Integer> symptom2Count = process(reader);
        write(outputFilename, symptom2Count);
    }

    @Override
    public BufferedReader read(String filename) throws SymptomException {
        try {
            // return new BufferedReader(new FileReader(filename)); // oldies but goldies
            return Files.newBufferedReader(Path.of(filename));   // Since Java 7+
        } catch (IOException e) {
            throw new SymptomException(String.format("Cannot open/read file %s", filename), e);
        }
    }

    /**
     * Count the number of occurrences of each symptom read from the passed-in BufferedReader
     * and return a <code>Map&lt;String, Integer&gt;</code>  where key is a <code>String</code> with the name of a symbol,
     * and value is an <code>Integer</code> with the number of occurrences of this symbol found in the file.
     * <u>
     *  <li>dry mouth ==> 10</li>
     *  <li>fever ==> 9</li>
     *  <li>cough ==> 6</li>
     *  <li>low blood pressure ==> 4</li>
     * </u>
     *
     * @param reader the Reader where to read the unordered symptoms
     * @return a Map of pairs (String: symptom name, Integer: number of occurrences of this symptom found via reader) ordered by symptom name.
     */
    @Override
    public Map<String, Integer> process(BufferedReader reader) throws SymptomException {

        try {
            Map<String, Integer> symptom2Count = new TreeMap<>();
            String symptom;
            while ((symptom = reader.readLine()) != null) {
                // Remove leading and trailing spaces from the symptom
                if (!symptom.strip().isEmpty()) {
                    Integer count = symptom2Count.getOrDefault(symptom, 0);
                    symptom2Count.put(symptom, ++count);
                }
            }
            return symptom2Count;
        } catch (IOException e) {
            throw new SymptomException("Error while reading the symptoms.", e);
        }
    }

    @Override
    public void write(String filename, Map<String, Integer> symptom2Count) throws SymptomException {
        Writer writer = null;
        try {
            // Writer writer = new BufferedWriter( new FileWriter(filename)); // oldies but goldies...
            writer = Files.newBufferedWriter(Path.of(filename)); // Shiny new way to do the same

            // Iterate over the Map entries: (symptom, count (i.e., number of occurrences))
            for (Map.Entry<String, Integer> entry : symptom2Count.entrySet()) {
                // Write a line for each symptom along with its number of occurrences with the format:
                // symptom = count
                writer.write(String.format("%s = %d\n", entry.getKey(), entry.getValue()));
            }
        } catch (IOException e) {
            throw new SymptomException(String.format("Cannot write to file %s", filename), e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ignored) {
                    // Do nothing
                }
            }
        }
    }
}
