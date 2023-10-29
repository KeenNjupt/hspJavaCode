package com.hspedu.super_;

public class C extends B {
    public void test(){
        //super.a find a from base class--b to Object class
        //the find rule is the same as the general rule, firstly match the name then access,
        //if the variable or method can't be accessed, output error
        System.out.println(super.a);
        super.f();
    }
}
