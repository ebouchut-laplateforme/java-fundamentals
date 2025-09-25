package com.ericbouchut.io.motionsickness;

import java.io.BufferedReader;
import java.util.Map;

public interface ISymptomProcessor {
    Map<String, Integer> process(BufferedReader reader) throws SymptomException;
}
