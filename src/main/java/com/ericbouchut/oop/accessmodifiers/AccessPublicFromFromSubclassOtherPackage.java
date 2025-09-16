package com.ericbouchut.oop.accessmodifiers;

import com.ericbouchut.oop.accessmodifiers.publicmod.AccessPublicFromClass;

public class AccessPublicFromFromSubclassOtherPackage extends AccessPublicFromClass {

    public static void main(String[] args) {
        AccessPublicFromFromSubclassOtherPackage o = new AccessPublicFromFromSubclassOtherPackage();

        o.accessPublicAttribute();
        o.callPublicMethod();

        System.out.println(o);
    }

    /**
     * Access a public attribute from a subclass within a different package.
     */
    public void accessPublicAttribute() {
        System.out.println("Access a public attribute from a subclass within a different package: Yes");
        publicAttribute = "subclass different package";
    }

    /**
     * Call a public method from a subclass within a different package.
     */
    public void callPublicMethod() {
        System.out.println("Call a public method from a subclass within a different package: Yes");
        publicMethod();
    }
}

