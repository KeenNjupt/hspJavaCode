package com.hspedu.inheritance_exercise;

public class Test {
    public static void main(String[] args) {
        B b = new B();
        //1. in B(): B.this(1)
        //2. in B(int n): default super()
        //3. in A() out "in A()"
        //4. in B(int n): out "in B(int n)"
        //5. in B(): out "in B()"
    }
}

class A{
    A(){
        System.out.println("in A()");
    }
}

class B extends A{
    B(){
        // because this() statement, there is not the super() statement
        this(1);
        System.out.println("in B()");
    }
    B(int n){
        //there is a super() statement
        System.out.println("in B(int n)");
    }
    B(int a, String b, double c){}
}
