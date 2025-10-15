package com.ericbouchut.record;

/**
 * When declaring a class with the `record` keyword,
 * the compiler automatically generates:
 *
 * - A `final` class  (meaning it cannot be inherited from)
 * - All fields are `private final`
 * - A canonical **constructor with parameters** matching the components
 * - Public **accessor** methods for each component
 *   getters without the usual `get` prefix).
 * - **No** setter!
 * - `equals()`, `hashCode()`,  `toString()` **methods** based on all components
 *
 * @param name the person name
 * @param age  the person age
 */
public record PersonWithRecord(String name, int age) {

    public static void main(String[] args) {
        PersonWithRecord alej = new PersonWithRecord("Aleijandro", 22);

        System.out.println(alej);

        // Accessors are not Javabeans acessors (no `get` prefix)
        // `name()` instead of `getName()`
        // `age()`  instead of `getAge()`

        System.out.println(alej.name());
        System.out.println(alej.age());

        PersonWithRecord alej2 = new PersonWithRecord("Aleijandro", 22);
        System.out.println(alej.equals(alej2));
    }
}
