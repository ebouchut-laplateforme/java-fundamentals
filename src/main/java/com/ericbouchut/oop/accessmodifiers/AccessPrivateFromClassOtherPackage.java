package com.ericbouchut.oop.accessmodifiers;

import com.ericbouchut.oop.accessmodifiers.privatemod.AccessPrivateFromClass;

public class AccessPrivateFromClassOtherPackage {

    /**
     * Instance of a class from another package with a private method and a private attribute.
     */
    public AccessPrivateFromClass otherClassDifferentPackage = new AccessPrivateFromClass();


    public static void main(String[] args) {
        AccessPrivateFromClassOtherPackage o = new AccessPrivateFromClassOtherPackage();

        o.accessPrivateAttribute();
        o.callPrivateMethod();

        System.out.println(o.otherClassDifferentPackage);
    }

    /**
     * Access a private attribute of another class from a different package.
     */
    public void accessPrivateAttribute() {
//        otherClassDifferentPackage.privateAttribute = "other class different package";
        System.out.println("❌ Access a private attribute from another another class in a different package: No");
    }

    /**
     * Call a private method of another class from a different package.
     */
    public void callPrivateMethod() {
//        otherClassDifferentPackage.callPrivateMethod();
        System.out.println("❌ Call a private method of another another class in a different package: No");
    }
}
