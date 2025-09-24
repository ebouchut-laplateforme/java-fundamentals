package com.ericbouchut.io.motionsickness;

import java.io.BufferedReader;

public interface ISymptomProcessor {
    void process(BufferedReader reader) throws SymptomException;
}
