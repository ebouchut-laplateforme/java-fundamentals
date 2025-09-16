package com.ericbouchut.oop.accessmodifiers.packagemod;

/**
 * TODO: Refactor: Use JUnit to instead of this bunch of classes, to make this more meaningful and self explanatory.
 */
public class AccessPackageFromClassSamePackage {

    public static void main(String[] args) {
        new AccessPackageFromClass().test();
    }

    public void test() {
        AccessPackageFromClass o = new AccessPackageFromClass();

        o.packageAttribute = "subclass same package";
        System.out.println("✅ Access package attribute from a class within the same package: Yes");
        System.out.println(this);

        o.packageMethod();
        System.out.println("✅ Call package method from a subclass within the same package: Yes");
    }
}
