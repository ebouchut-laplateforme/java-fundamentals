package com.ericbouchut.oop.accessmodifiers;

import com.ericbouchut.oop.accessmodifiers.protectedmod.AccessProtectedFromClass;

public class AccessProtectedFromSubclassOtherPackage extends AccessProtectedFromClass {

    public static void main(String[] args) {
        AccessProtectedFromSubclassOtherPackage o = new AccessProtectedFromSubclassOtherPackage();

        o.accessProtectedAttribute();
        o.callProtectedMethod();

        System.out.println(o);
    }

    /**
     * Access a protected attribute from a subclass within a different package.
     */
    public void accessProtectedAttribute() {
        System.out.println("Access a protected attribute from a subclass in a different package: Yes");
        protectedAttribute = "subclass different package";
    }

    /**
     * Call a protected method from a subclass within a different package.
     */
    public void callProtectedMethod() {
        System.out.println("Call a protected method from a subclass in a different package: Yes");
        protectedMethod();
    }
}


