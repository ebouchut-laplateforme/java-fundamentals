package com.ericbouchut.oop.accessmodifiers.protectedmod;

public class AccessProtectedFromClass {
    protected String protectedAttribute;

    public static void main(String[] args) {
        AccessProtectedFromClass o = new AccessProtectedFromClass();

        // Call a protected method from the same class it is defined in
        o.callProtectedMethod();

        // Modify a protected attribute from the same class it is defined in
        o.accessProtectedAttribute();

        System.out.println(o);
    }

    /**
     * Access a protected attribute from an instance  method.
     * Both are defined in this class.
     */
    public void accessProtectedAttribute() {
        System.out.println("Access a protected attribute within a class: Yes");
        protectedAttribute = "parent";
    }

    /**
     * Call a protected method defined in this class
     */
    public void callProtectedMethod() {
        System.out.println("Call a protected method within a class: Yes");
        protectedMethod();
    }

    /**
     * @return a String containing a description of this object instance
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Class name not prefixed with the package
        sb.append(this.getClass().getSimpleName());
        sb.append("{protectedAttribute=\"");
        sb.append(protectedAttribute);
        sb.append("\"}");

        return sb.toString();
    }

    protected void protectedMethod() {
        System.out.println("AccessProtectedFromClass.protectedMethod() called");
    }
}
