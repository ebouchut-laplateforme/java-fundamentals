package com.ericbouchut.io.motionsickness;

public interface ISymptomWriter {
    void write(String filename) throws SymptomException;
}
