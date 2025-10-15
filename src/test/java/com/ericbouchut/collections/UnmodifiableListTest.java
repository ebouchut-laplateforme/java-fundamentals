package com.ericbouchut.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// TIL; No need to use access modifiers for test classes and test methods,
// because JUnit finds them anyway using Java Introspection.
class UnmodifiableListTest {

    @Nested
    @DisplayName("Modification attempts")
    class ModificationAttempts {
        @Test
        @DisplayName("Adding an item fails/raises UnsupportedOperationException")
        void throwsExceptionOnAdd() {
            List<String> list             = List.of("A", "B", "C");
            List<String> unmodifiableList = Collections.unmodifiableList(list);

            assertThrows(UnsupportedOperationException.class, () -> {
                unmodifiableList.add("D");
            }, "Attempting to add an item to an unmodifiable list fails/raises UnsupportedOperationException");
        }

        @Test
        @DisplayName("Removing an item fails/raises UnsupportedOperationException")
        void throwsExceptionOnRemove() {
            List<String> list             = List.of("A", "B", "C");
            List<String> unmodifiableList = Collections.unmodifiableList(list);

            assertThrows(UnsupportedOperationException.class, () -> {
                unmodifiableList.remove("A");
            }, "Attempting to remove an item from an unmodifiable list fails/raises UnsupportedOperationException");
        }
    }

    @Nested
    class ReadingAttempts {

        @Test
        @DisplayName("Reflects changes made to the backing list")
        void reflectsBackingListChanges() {
            // Backing list
            List<String> list = new ArrayList<>();
            list.add("A");
            list.add("B");
            list.add("C");

            List<String> unmodifiableList = Collections.unmodifiableList(list);

            // Same before the modification of the backing list
            assertEquals(list,       unmodifiableList, "unmodifiable list contains the same items as the backed list (i.e., the underlying list used to build it)" );
            assertEquals(3, unmodifiableList.size());

            list.add("D"); // Add an item to the backing list

            // Same after the modification of the backing list
            assertEquals(4, unmodifiableList.size(), "Unmodifiable List can see the changes made to the backing list");
            assertTrue(unmodifiableList.contains("D"), "Unmodifiable list view can view the backing list as it changes");
        }
    }
}
