package com.ericbouchut.io.motionsickness;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class SymptomsCounter implements ISymptomReader, ISymptomProcessor, ISymptomWriter, ISymptomsCounter {
    Map<String, Integer> symptom2Count = new TreeMap<>();

    /**
     *
     * @param inputFilename
     * @param outputFilename
     * @throws SymptomException
     */
    @Override
    public void count(String inputFilename, String outputFilename) throws SymptomException {
        BufferedReader reader = read(inputFilename);
        process(reader);
        write(outputFilename);
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

    @Override
    public void process(BufferedReader reader) throws SymptomException {
        symptom2Count.clear();

        try {
            String symptom;
            while (((symptom = reader.readLine()) != null)) {
                // Remove leading and trailing spaces
                symptom = symptom.trim();

                if (!symptom.isEmpty()) {
                    Integer count = this.symptom2Count.getOrDefault(symptom, 0);
                    this.symptom2Count.put(symptom, ++count);
                }
            }
        } catch (IOException e) {
            throw new SymptomException("Error while reading the symptoms.", e);
        }
    }

    @Override
    public void write(String filename) throws SymptomException {
        Writer writer = null;
        try {
            // Writer writer = new BufferedWriter( new FileWriter(filename)); // oldies but goldies...
            writer = Files.newBufferedWriter(Path.of(filename)); // Shiny new way to do the same, using these helper class and method!

            // Iterate over the Map entries: (symptom, count (i.e., number of occurrences))
            for (Map.Entry<String, Integer> entry : symptom2Count.entrySet()) {
                // Write a line for each symptom along with its number of occurrences like so:
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
