package com.ericbouchut.io.motionsickness;

import java.util.Map;

public interface ISymptomWriter {
    void write(String filename, Map<String, Integer> symbol2Count) throws SymptomException;
}
