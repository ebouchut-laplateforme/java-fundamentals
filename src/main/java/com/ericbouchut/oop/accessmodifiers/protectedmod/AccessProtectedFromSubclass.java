package com.ericbouchut.oop.accessmodifiers.protectedmod;

public class AccessProtectedFromSubclass extends AccessProtectedFromClass {

    public static void main(String[] args) {
        AccessProtectedFromSubclass o = new AccessProtectedFromSubclass();

        o.accessProtectedAttribute();
        o.callProtectedMethod();

        System.out.println(o);
    }

    /**
     * Access a protected attribute defined in the parent class.
     */
    public void accessProtectedAttribute() {
        System.out.println("Access a protected attribute of a parent class from a subclass: Yes");
        protectedAttribute = "child";
    }

    /**
     * Call a protected method defined in the parent class
     */
    public void callProtectedMethod() {
        System.out.println("Call a protected method of a parent class from a subclass: Yes");
        protectedMethod();
    }
}
