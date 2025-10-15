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
public record PersonWithRecord(String name, int age, String email) {
    public static final String EMAIL_INVALID = "email is not valid: must contain an ampersand character (@)";

    /**
     * This validator triggered <b>after the constructor</b> (Thx. Alej for enlighting me),
     * (which means the instance's fields have already been set at this stage)
     * It ensures the e-mail is valid
     * and if not raises an <code>IllegalArgumentException</code>.
     *
     * @param name person name
     * @param age person age
     * @param email person email (must contain an ampersand)
     *
     * @throws IllegalArgumentException if email is not valid
     */
    public PersonWithRecord {
        if (!email.contains("@")) {
            throw new IllegalArgumentException(EMAIL_INVALID);
        }
    }

    public static void main(String[] args) {
        PersonWithRecord alej = new PersonWithRecord("Aleijandro", 22, "alej@example.com");

        System.out.println(alej);

        // Accessors are not Javabeans acessors (no `get` prefix)
        // `name()` instead of `getName()`
        // `age()`  instead of `getAge()`

        System.out.println(alej.name());
        System.out.println(alej.age());
        System.out.println(alej.email());

        PersonWithRecord alej2 = new PersonWithRecord("Aleijandro", 22, "alej@example.com");
        System.out.println(alej.equals(alej2));
    }
}
