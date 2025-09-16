package com.ericbouchut.oop.accessmodifiers.packagemod;

public class AccessPackageFromSubclass extends AccessPackageFromClass {

    public static void main(String[] args) {
        new AccessPackageFromSubclass().test();
    }

    public void test() {
        System.out.println("✅ Access package attribute from a subclass: Yes");
        packageAttribute = "subclass";

        System.out.println("✅ Call package method from a subclass: Yes");
        packageMethod();

        System.out.println(this);
    }
}
