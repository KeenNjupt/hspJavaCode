package com.hspedu.override;

public class Derived extends Base{
    //1. the method of subclass must have the same method signature as the overridden method in base class
    public void cry(){
        System.out.println("in Derived.cry");
    }
    //2.the return type of Derived.f1 must be the return type of Base.f1 of that's subclass
    //Base.f1 return Object class, Derived.f1 return String class, the String class is the subclass of
    //Object class

    //assumption: Derived d = new Derived(); Base b = (Base)d; Object fr = b.f1();
    //b.f1() return the String type, the String type must be can assign to the Object type
    public String f1(){
        return null;
    }
    //error
//    public Object f2(){
//        return null;
//    }

    //3. the method in subclass can't narrow the access rights that in base class
    public void f3(){

    }
    //error
//    private void f3(){
//
//    }

    //there isn't function hidden in java
    public void f3(int a){

    }
}
