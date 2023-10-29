package com.hspedu.pkg;

import com.hspedu.accessmodifier.A;

public class C {
    public void test(){
        // in different same package, can only access the public field and method
        A a = new A();
        System.out.println("a.publicNum = " + a.publicNum);
        a.publicFunc();

    }
}
