package com.hspedu.override;

public class OverrideDetail {
    public static void main(String[] args) {
        //the member variable doesn't have the override
        //the member variable accessed is the compile type class's member variable
        B b = new B();
        A a = (A)b;
        A aa = b;
        a.f(); // member function has the override, call B.f() :runtime type
        System.out.println(a.num);//the member variable doesn't have the override
        //call A.num: compile type
        System.out.println("==============");

        //aa instanceof B operator: be used to determine whether the runtime type of object aa
        //is the B class or the subclass of B class
        System.out.println(a instanceof B);//true
        System.out.println(a instanceof A);//true

//        System.out.println(a instanceof String);//error
        Object obj = new Object();
        System.out.println(obj instanceof A);//false

    }
}

class A{
    public int num = 20;
    public void f(){
        System.out.println("in A.f()");
    }
}

class B extends A{
    public int num = 30;
    public void f() {
        System.out.println("in B.f()");
    }
}

