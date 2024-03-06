package com.keen.generic_;

import java.util.ArrayList;

public class SelfDefinedGenericInterfaceTest {
    public static void main(String[] args) {


    }
}


interface InterfaceA<T>{
    //接口中的变量为静态变量，不能声明泛型类型的变量
//    T a;
    void show(T a);

    //jdk8中，可以在接口中使用默认方法
    default void method(T a){

    }
}
//实现具有泛型类型的接口，需要指定泛型类型,不指定则泛型类型默认为Object
class InterfaceAClass implements InterfaceA{
    @Override
    public void show(Object a) {

    }

    @Override
    public void method(Object a) {
        InterfaceA.super.method(a);
    }
}

//继承接口，使用父接口的泛型
interface InterfaceB<T> extends InterfaceA<T>{

}

//继承接口，指定父接口的泛型类型
interface InterfaceC extends InterfaceA<String>{

}

//实现接口
class InterfaceCClass implements InterfaceC{
    @Override
    public void show(String a) {

    }

    @Override
    public void method(String a) {
        InterfaceC.super.method(a);
    }
}
