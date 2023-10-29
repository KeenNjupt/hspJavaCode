package com.hspedu.accessmodifier;

public class B {
    public void test(){
        // in same package, can access public, protected, default
        A a = new A();
        System.out.println("a.publicNum = " + a.publicNum + " a.protectedNum = " + a.protectedNum
        + " a.defaultNum = " + a.defaultNum);

        a.publicFunc();
        a.protectedFunc();
        a.defaultFunc();
    }

}
