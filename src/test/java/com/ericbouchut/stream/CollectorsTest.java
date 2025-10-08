package com.ericbouchut.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.fail;

class CollectorsTest {
    @Test
    void counting() {
        Stream<String> people = Stream.of("Alex", "Habib", "Ines", "Braulio", "Ximenia", "Baptiste");
        // TODO: Test Forest, test...
    }

    @Test
    void groupingBy() {
        Stream<String> logLevels = Stream.of("ERROR", "INFO", "WARN", "ERROR", "INFO");

        Map<String, List<String>> actualByLogLevel = logLevels.collect(Collectors.groupingBy(logLevel -> logLevel));
//        fail("TODO: Do the rest");
    }

}
