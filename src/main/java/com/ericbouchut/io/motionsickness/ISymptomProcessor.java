package com.ericbouchut.io.motionsickness;

import java.io.BufferedReader;
import java.util.Map;

public interface ISymptomProcessor {
    // TODO: Refactor to make the processor less BufferedReader centric, to be able to read from something else such as an URL.
    Map<String, Integer> process(BufferedReader reader) throws SymptomException;
}
