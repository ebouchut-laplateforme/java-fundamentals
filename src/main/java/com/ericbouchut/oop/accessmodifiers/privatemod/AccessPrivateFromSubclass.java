package com.ericbouchut.oop.accessmodifiers.privatemod;

public class AccessPrivateFromSubclass extends AccessPrivateFromClass {
    /**
     * Try to call a private method defined in the parent class
     */
    public void callPrivateMethod() {
//         super.accessPrivateMethod();
        System.out.println("❌ CANNOT call a private method defined in the parent class");
    }

    /**
     * CANNOT access a private attribute defined in the parent class.
     */
    public void accessPrivateAttribute() {
//        privateAttribute = "child";
        System.out.println("❌ CANNOT access a private attribute defined in in a parent class from a subclass");
    }

    public static void main(String[] args) {
        AccessPrivateFromSubclass o = new AccessPrivateFromSubclass();

        // Access a private attribute defined in the parent class
        o.accessPrivateAttribute();

        // Call a private method defined in the mother class
        o.callPrivateMethod();

        System.out.println(o);
    }
}
