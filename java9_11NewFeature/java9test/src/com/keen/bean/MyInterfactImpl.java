package com.keen.bean;

public class MyInterfactImpl implements MyInterface{

    @Override
    public void methodAbstract() {

    }

    @Override
    public void methodDefault() {
        MyInterface.super.methodDefault();
    }

    public static void main(String[] args) {
        //接口中的静态方法只能通过 接口类.静态方法的方式去调用
        //接口的实现类不能调用接口的静态方法
        MyInterface.methodStatic();

        MyInterfactImpl myInterfact = new MyInterfactImpl();
        myInterfact.methodDefault();
    }
}
