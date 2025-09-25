package com.ericbouchut.io.motionsickness;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.TreeMap;

public class StreamFileOccurrenceCounter implements ISymptomsCounter {
    @Override
    public void count(String inputFilename, String outputFilename) throws SymptomException  {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(outputFilename))) {

            Files.lines(Path.of(inputFilename)) // Build a stream of symptoms of type String
                    .map(String::strip) // Remove leading and trailing white spaces from each symptom
                    .filter(line -> !line.isEmpty()) // remove empty symptoms from the Stream

                    //   Stream<String>: {"headache", "fever", "headache", "headache", "fever", "nausea"}
                    .collect(
                            Collectors.groupingBy(
                                    symptom -> symptom,   // "Step" 1
                                    TreeMap<String, Long>::new, // "Step" 2
                                    Collectors.counting()       // "Step" 3
                            )
                    )
                    // Step 1:  Collectors.groupingBy(symptom -> symptom, ...)
                    //   Group symptom occurrences by unique name where (Key=symptom, Value=list of all occurrences of this symptom)
                    //   Map<String, List<String>>: {"headache" = ["headache", "headache", "headache"], "fever" = ["fever", "fever"], "nausea": ["nausea"]}
                    // Step 2: Collectors.groupingBy(symptom -> symptom, TreeMap::new; ...) // keys are ordered
                    //   TreeMap<String, List<String>>: {"headache" = ["fever" = ["fever", "fever"], "headache", "headache", "headache"], "nausea": ["nausea"]}
                    // Step 3: Collectors.groupingBy(symptom -> symptom, TreeMap::new; Collectors.counting())
                    //   Map<String, Long>: {"fever" = 2L, "headache" = 3L, "nausea": 1L}
                    .forEach( (symptom, count) -> {
                        try {
                            writer.write(symptom + " = " + count);
                            writer.newLine();
                        } catch (IOException e) {
                            // TODO: Why do I need to cach IOException here in this lambda even though it is catched below?
                        }
                    });
        } catch (IOException e) {
            throw new SymptomException("Error while reading/processing/writing the file", e);
        }

    }
}
