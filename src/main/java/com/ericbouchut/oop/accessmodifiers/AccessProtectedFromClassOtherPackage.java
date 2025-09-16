package com.ericbouchut.oop.accessmodifiers;

import com.ericbouchut.oop.accessmodifiers.protectedmod.AccessProtectedFromClass;

public class AccessProtectedFromClassOtherPackage {

    /**
     * A class within the same package with a public method and a public attribute.
     */
    public AccessProtectedFromClass otherClassDifferentPackage = new AccessProtectedFromClass();


    public static void main(String[] args) {
        AccessProtectedFromClassOtherPackage o = new AccessProtectedFromClassOtherPackage();

        o.accessProtectedAttribute();
        o.callProtectedMethod();

        System.out.println(o.otherClassDifferentPackage);
    }

    /**
     * Access a protected attribute of another class in a different package.
     */
    public void accessProtectedAttribute() {
//            otherClassDifferentPackage.protectedAttribute = "other class different package";
        System.out.println("❌ Access a protected attribute from a class in a different package: No");
    }

    /**
     * Call a protected method of another class in a different package.
     */
    public void callProtectedMethod() {
//            otherClassDifferentPackage.protectedMethod();
        System.out.println("❌ Call a protected method from a class in a different package: No");
    }
}
