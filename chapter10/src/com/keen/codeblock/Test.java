package com.keen.codeblock;

public class Test {
    public static void main(String[] args) {
        //when the class is loaded, the static code block will be called
        //1. create an object of class
        new A();//in new A(), the A's static code block will be called
        //2. create an object of subclass, the baseclass's static code block will be called
        new B();//in new A(), the A's and B's code block will be called, first A
        //3. call the static member variable and member function, the static code block will be called
        int a = C.a;
        C.f();
        //but class will only be loaded once, so the static code block will only be called once

        //when create the object, the non-static code block will be called
        //the static code block can only call the static member, the non-static code block can
        //call the static member and the non-static member

    }
}

class A{

    //non-static code block
    {
        System.out.println("in A's non-static code block");
    }

    //static code block
    static{
        System.out.println("in A's static code block");
    }
}

class B extends A{
    //static code block
    static{
        System.out.println("in B's static code block");
    }
}

class C{
    public static int a = 10;
    public static void f(){

    }
    //non-static code block
    {
        System.out.println("in C's non-static code block");
    }
    //static code block
    static{
        System.out.println("in C's static code block");
    }
}

class D{
    public static int a = 10;
    public int b = 20;
    static{
        a = 20;
//        b = 1;
    }
    {
        a = 30;
        b = 10;
    }
}
