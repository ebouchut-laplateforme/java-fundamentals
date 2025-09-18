package com.ericbouchut.oop.accessmodifiers.packagemod;

public class AccessPackageFromSubclass extends AccessPackageFromClass {

    public static void main(String[] args) {
        new AccessPackageFromSubclass().test();
    }

    public void test() {
        System.out.println("✅ Access a package attribute from a subclass within the same package: Yes");
        packageAttribute = "subclass";

        System.out.println("✅ Call a package method from a subclass within the same package: Yes");
        packageMethod();

        System.out.println(this);
    }
}
