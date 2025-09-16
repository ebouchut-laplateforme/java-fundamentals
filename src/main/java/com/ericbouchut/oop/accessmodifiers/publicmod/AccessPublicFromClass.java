package com.ericbouchut.oop.accessmodifiers.publicmod;

public class AccessPublicFromClass {
    public String publicAttribute;

    /**
     * Call a public method from the same class it is defined in
     * Modify a public attribute from the same class it is defined in
     */
    public static void main(String[] args) {
        AccessPublicFromClass o = new AccessPublicFromClass();

        o.accessPublicAttribute();
        o.callPublicMethod();

        System.out.println(o);
    }

    public void publicMethod() {
        System.out.println("AccessPublicFromClass.publicMethod() called");
    }

    /**
     * Access a public attribute from an instance  method.
     * Both are defined in this class.
     */
    public void accessPublicAttribute() {
        publicAttribute = "parent";
    }

    /**
     * Call a public method defined in this class
     */
    public void callPublicMethod() {
        publicMethod();
    }

    /**
     * @return a String containing a description of this object instance
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // class name not prefixed with the full package
        sb.append(this.getClass().getSimpleName());
        sb.append("{publicAttribute=\"");
        sb.append(publicAttribute);
        sb.append("\"}");

        return sb.toString();
    }
}
