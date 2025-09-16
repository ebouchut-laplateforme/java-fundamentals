package com.ericbouchut.oop.accessmodifiers;

import com.ericbouchut.oop.accessmodifiers.packagemod.AccessPackageFromClass;

public class AccessPackageFromClassOtherPackage {

    /**
     * Cannot access a package attribute of another class from a different package.
     * Cannot call a package method of another class from a different package
     */
    public static void main(String[] args) {
        AccessPackageFromClass o = new AccessPackageFromClass();

//        o.packageAttribute = "other class different package";
        System.out.println("❌ Access a package attribute defined in another class from a different package: No");

//        o.packageMethod();
        System.out.println("❌ Call a package method defined in another class from a different package: No");

        System.out.println(o);
    }
}


