package com.ericbouchut.oop.accessmodifiers;

import com.ericbouchut.oop.accessmodifiers.packagemod.AccessPackageFromClass;

public class AccessPackageFromSubclassOtherPackage extends AccessPackageFromClass {

    public static void main(String[] args) {
        new AccessPackageFromSubclassOtherPackage().test();
    }

    public void test() {
//        packageAttribute = "subclass other package";
        System.out.println("❌ Access a package attribute from a class in a different package: No");
        System.out.println(this);

        System.out.println("❌ Call a package method from a class in a different package: No");
//        packageMethod();
    }
}
