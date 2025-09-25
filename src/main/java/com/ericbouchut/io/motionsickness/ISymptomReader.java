package com.ericbouchut.io.motionsickness;

import java.io.BufferedReader;
import java.io.IOException;

public interface  ISymptomReader {
    BufferedReader read(String filename) throws IOException, SymptomException;
}
