package com.hspedu.view_sourcecode;

public class Finalize {
    public static void main(String[] args) {
        A kk = new A("kk");

        kk = null; //the object that kk point become garbage
        System.gc();//Run the garbage collector
        //when the object is collector, the finalize function will be automatically invoked
        System.out.println("the end of program");
    }
}

class A{
    String name;

    public A(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("in finalize()");
    }
}
