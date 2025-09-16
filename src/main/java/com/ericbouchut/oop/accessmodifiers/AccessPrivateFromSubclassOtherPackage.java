package com.ericbouchut.oop.accessmodifiers;

import com.ericbouchut.oop.accessmodifiers.privatemod.AccessPrivateFromClass;

public class AccessPrivateFromSubclassOtherPackage extends AccessPrivateFromClass {

    public static void main(String[] args) {
        AccessPrivateFromSubclassOtherPackage o = new AccessPrivateFromSubclassOtherPackage();

        o.accessPrivateAttribute();
        o.callPrivateMethod();

        System.out.println(o);
    }

    /**
     * Access a private attribute from a subclass in a different package.
     */
    public void accessPrivateAttribute() {
//        privateAttribute = "subclass different package";
        System.out.println("❌ Access a private attribute from a subclass in a different package: No");
    }

    /**
     * Call a private method from a subclass in a different package.
     */
    public void callPrivateMethod() {
//        privateMethod();
        System.out.println("❌ Call a private method from a subclass in a different package: No");
    }
}
