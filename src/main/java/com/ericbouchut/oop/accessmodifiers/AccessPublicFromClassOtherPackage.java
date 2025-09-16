package com.ericbouchut.oop.accessmodifiers;

import com.ericbouchut.oop.accessmodifiers.publicmod.AccessPublicFromClass;

public class AccessPublicFromClassOtherPackage {

    /**
     * A class within the same package with a public method and a public attribute.
     */
    public AccessPublicFromClass otherClassDifferentPackage = new AccessPublicFromClass();

    /**
     * Access a public attribute of another class from a different package.
     */
    public void accessPublicAttribute() {
        otherClassDifferentPackage.publicAttribute = "other class different package";
    }

    /**
     * Call a public method of another class from a different package.
     */
    public void callPublicMethod() {
        otherClassDifferentPackage.publicMethod();
    }

    public static void main(String[] args) {
        AccessPublicFromClassOtherPackage o = new AccessPublicFromClassOtherPackage();

        o.accessPublicAttribute();
        System.out.println(o.otherClassDifferentPackage);

        o.callPublicMethod();
    }
}
