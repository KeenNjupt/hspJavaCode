package com.hspedu.pkg;

import com.hspedu.accessmodifier.A;

public class SubclassOfA extends A {
    public void test(){
        SubclassOfA subclassOfA = new SubclassOfA();
        System.out.println("subclassOfA.publicNum = " + subclassOfA.publicNum + " subclassOfA.protectedNum = " + subclassOfA.protectedNum);
        subclassOfA.publicFunc();
        subclassOfA.protectedFunc();
    }
}
