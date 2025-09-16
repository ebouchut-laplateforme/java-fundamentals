package com.ericbouchut.oop.accessmodifiers.privatemod;

public class AccessPrivateFromClass {
    private String privateAttribute;

    private void privateMethod() {
        System.out.println("AccessPrivateFromClass.privateMethod() called");
    }

    /**
     * Access a private attribute from an instance method
     * (both defined in this class).
     */
    public void accessPrivateAttribute() {
        privateAttribute = "parent";
    }

    /**
     * Call a private method defined in this class
     */
    private void callPrivateMethod() {
        privateMethod();
    }

    /**
     * @return a String containing a description of this object instance
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // class name not prefixed with the package
        sb.append(this.getClass().getSimpleName());
        sb.append("{privateAttribute=\"");
        sb.append(privateAttribute);
        sb.append("\"}");

        return sb.toString();
    }

    public static void main(String[] args) {
        AccessPrivateFromClass o = new AccessPrivateFromClass();

        // Modify a private attribute from the same class it is defined in
        o.accessPrivateAttribute();

        // Call a private method from within the same class
        o.callPrivateMethod();

        System.out.println(o);
    }
}

