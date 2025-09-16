package com.ericbouchut.oop.accessmodifiers.packagemod;

public class AccessPackageFromClass {
    String packageAttribute;

    public static void main(String[] args) {
        new AccessPackageFromClass().test();
    }

    public void test() {
        packageAttribute = "parent";
        System.out.println("✅ Access a package attribute from the class it is defined in: Yes");
        System.out.println(this);

        System.out.println("✅ Call a package method from the class it is defined in: Yes");
        packageMethod();
    }

    void packageMethod() {
        System.out.println("packageMethod() called");
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append("packageAttribute=").append(packageAttribute);
        sb.append("}");

        return sb.toString();
    }
}
