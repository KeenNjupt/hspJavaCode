package com.keen.interfacetest;

public class InterfaceAndExtend {
    public static void main(String[] args) {
        new C().f();
    }
}

interface A{
    int x = 1;
}
class B{
    int x = 2;
}
class C extends B implements A{
    public void f(){
//        System.out.println(x); //冲突
        System.out.println(A.x);//A中的x
        System.out.println(super.x);//B中的x
    }
}

