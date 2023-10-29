package com.hspedu.debug;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //对象创建过程
        //1.加载类信息
        //2.1 默认初始化，2.2 显示初始化，2.3 构造函数初始化
        //3. 返回对象地址
        Person jack = new Person("jack", 10);
    }
}

class Person{
    String name;
    int age = 10;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
