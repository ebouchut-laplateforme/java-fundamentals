package com.ericbouchut.oop.accessmodifiers.publicmod;

public class AccessPublicFromClassSamePackage {

    /**
     * A class within the same package with a public method and a public attribute.
     */
    AccessPublicFromClass otherClassSamePackage = new AccessPublicFromClass();


    public static void main(String[] args) {
        AccessPublicFromClassSamePackage o = new AccessPublicFromClassSamePackage();

        o.accessPublicAttribute();
        System.out.println(o.otherClassSamePackage);

        o.callPublicMethod();
    }

    /**
     * Access a public attribute of another class within the same package.
     */
    public void accessPublicAttribute() {
        otherClassSamePackage.publicAttribute = "other class same package";
    }

    /**
     * Call a public method of another class within the same package
     */
    public void callPublicMethod() {
        otherClassSamePackage.publicMethod();
    }
}
