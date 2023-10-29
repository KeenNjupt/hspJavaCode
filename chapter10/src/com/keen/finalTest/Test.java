package com.keen.finalTest;

public class Test {
    public static void main(String[] args) {
        final double RATE = 1.0; //不可以被重新赋值
//        RATE = 2.0;
    }
}

class A{
    public final void f(){ //不可以被子类重写

    }
    public void g(){

    }
}

final class B{ //不可以被继承

}
