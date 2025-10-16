package com.ericbouchut.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {

    public static void main(String[] args) {
        MapExample example = new MapExample();

        System.out.println("In a HashMap keys are NOT ordered.");
        example.populateAndDisplaySymptomsMap(new HashMap());

        System.out.println();
        System.out.println("In a TreeMap keys are ordered.");
        example.populateAndDisplaySymptomsMap(new TreeMap());
    }

    public void populateAndDisplaySymptomsMap(Map<String, Integer> symmptomsMap) {
        populateSymptomsMap(symmptomsMap);
        displaySymptomsMap(symmptomsMap);
    }

    public void populateSymptomsMap(Map<String, Integer> symptomsMap) {
        symptomsMap.put("fever",     42);
        symptomsMap.put("cough",     5);
        symptomsMap.put("dizziness", 3);
    }

    protected void displaySymptomsMap(Map<String, Integer> symptomsMap) {
        // Display the concrete Map class
        System.out.println(symptomsMap.getClass().getSimpleName());

        // Iterate over map entries.
        // A map entry is a (Key, Value) pair where:
        // - Key   = symptom name
        // - Value = symptom count
        for(Map.Entry<String, Integer> symptomPair: symptomsMap.entrySet()) {
            String symptomName        = symptomPair.getKey();
            Integer symptomCount = symptomPair.getValue();

            System.out.println(symptomName + " = " + symptomCount);
        }
    }
}
