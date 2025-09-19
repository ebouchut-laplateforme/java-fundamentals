package com.ericbouchut.oop.inheritance;

/**
 * Classes implementing this interface can load and save their configuration.
 * They must implement all the methods declared below.
 */
public interface Configurable {
    void loadConfig();
    void saveConfig();
}
