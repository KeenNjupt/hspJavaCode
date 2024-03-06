package com.keen.generic_;

import java.util.ArrayList;

public class GenericExtend {
    public static void main(String[] args) {
        //泛型没有继承性
        //ArrayList<Object> list = new ArrayList<String>();
        ArrayList<Object> objects = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<A1> a1s = new ArrayList<>();
        ArrayList<A2> a2s = new ArrayList<>();
        ArrayList<A3> a3s = new ArrayList<>();
        //泛型的通配符
        //<?>表示可接受任意泛型
        printCollection(objects);
        printCollection(strings);
        printCollection(a1s);
        printCollection(a2s);
        printCollection(a3s);

        //<? extends A1>表示可以接受 A1以及A1的子类
        //printCollection1(objects); 错误
        //printCollection1(strings); 错误
        printCollection1(a1s);
        printCollection1(a2s);
        printCollection1(a3s);

        //<? extends A1>表示可以接受 A1以及A1的父类
        printCollection2(objects);
        //printCollection2(strings); 错误
        printCollection2(a1s);
        //printCollection2(a2s);错误
        //printCollection2(a3s);错误



    }

    public static void printCollection(ArrayList<?> list){

    }
    public static void printCollection1(ArrayList<? extends A1> list){

    }

    public static void printCollection2(ArrayList<? super A1> list){

    }
}

class A1{

}

class A2 extends A1{

}

class A3 extends A2{

}
