package com.ericbouchut.oop.accessmodifiers.protectedmod;

public class AccessProtectedFromClassSamePackage {

    /**
     * A class within the same package with a protected method and a public attribute.
     */
    AccessProtectedFromClass otherClassSamePackage = new AccessProtectedFromClass();

    /**
     * Access a protected attribute of another class within the same package.
     */
    public void accessProtectedAttribute() {
        otherClassSamePackage.protectedAttribute = "other class same package";
    }

    /**
     * Call a protected method of another class within the same package
     */
    public void callProtectedMethod() {
        otherClassSamePackage.protectedMethod();
    }

    public static void main(String[] args) {
        AccessProtectedFromClassSamePackage o = new AccessProtectedFromClassSamePackage();

        o.accessProtectedAttribute();
        o.callProtectedMethod();

        System.out.println(o.otherClassSamePackage);
    }
}
