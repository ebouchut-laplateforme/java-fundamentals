package com.ericbouchut.record;

import java.util.Objects;

/**
 * This how we create a class <b>before</b> Java 14+
 * (i.e., without using the <code>record</code> keyword).
 *
 * @see PersonWithRecord
 */
public final class PersonWithoutRecord {
    private final String name;
    private final int age;

    public PersonWithoutRecord(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PersonWithoutRecord person = (PersonWithoutRecord) obj;
        return age == person.age
                && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
