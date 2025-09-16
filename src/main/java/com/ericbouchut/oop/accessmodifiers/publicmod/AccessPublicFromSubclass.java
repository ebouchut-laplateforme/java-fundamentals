package com.ericbouchut.oop.accessmodifiers.publicmod;

public class AccessPublicFromSubclass extends AccessPublicFromClass {

    public static void main(String[] args) {
        AccessPublicFromSubclass o = new AccessPublicFromSubclass();

        o.accessPublicAttribute();
        System.out.println(o);

        o.callPublicMethod();
    }

    /**
     * Access the <code>AccessPublicFromSubclass</code> defined in the parent class.
     */
    public void accessPublicAttribute() {
        publicAttribute = "child";
    }

    /**
     * Call a public method defined in the parent class
     */
    public void callPublicMethod() {
        super.callPublicMethod(); // ==> Call AccessPublicFromClass.callPublicMethod()
        System.out.println("AccessPublicFromSubclass.publicMethod() called");
    }
}
