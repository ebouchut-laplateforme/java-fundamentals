package com.ericbouchut.oop.accessmodifiers.privatemod;

public class AccessPrivateFromClassSamePackage {
    /**
     * A class within the same package with a private (method and attribute).
     */
    public AccessPrivateFromClass otherClassSamePackage = new AccessPrivateFromClass();

    public static void main(String[] args) {
        AccessPrivateFromClassSamePackage o = new AccessPrivateFromClassSamePackage();

        o.accessPrivateAttribute();
        o.callPrivateMethod();

        System.out.println(o.otherClassSamePackage);
    }

    /**
     * Access a private attribute of another class within the same package.
     */
    public void accessPrivateAttribute() {
//        otherClassSamePackage.privateAttribute = "other class same package";
        System.out.println("❌ CANNOT access a private attribute defined in another class within the same package");
    }

    /**
     * Call a private method of another class within the same package
     */
    public void callPrivateMethod() {
//        otherClassSamePackage.privateMethod();
        System.out.println("❌ CANNOT call a private method defined in cl another class within the same package");
    }
}
