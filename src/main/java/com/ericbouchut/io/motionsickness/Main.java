package com.ericbouchut.io.motionsickness;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        String inputFilename;
        String outputFilename;

        try {
            if (args.length >= 2) {
                inputFilename = args[0];
                outputFilename = args[1];
            } else {
                URI inputURI = Main.class.getClassLoader().getResource("symptoms.txt").toURI();
                inputFilename = Path.of(inputURI).toString();
                outputFilename = "/tmp/results.txt";
            }

            new StreamSymptomCounter().count(inputFilename, outputFilename);
        } catch (SymptomException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
