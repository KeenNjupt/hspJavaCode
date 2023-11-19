package com.keen.Wrapper;

import java.util.ArrayList;

public class WrapperTest {
    public static void main(String[] args) {
        //装箱：基本类型->包装器类型
        //拆箱：包装器类型->基本类型

        //jdk5之前为手动装箱和拆箱
        int a = 10;
        //手动装箱
        Integer integer1 = new Integer(a);
        Integer integer2 = Integer.valueOf(a);
        //手动拆箱
        int a1 = integer1.intValue();

        //jdk5及以后为自动装箱和拆箱
        //自动装箱,底层调用的仍是Integer.valueof()
        Integer integer3 = a;
        //自动拆箱,底层调用的仍是integer3.intValue()
        int a2 = integer3;

        Object ob1 = true ? new Integer(1):new Double(2);
        //三元运算符是一个整体，new Integer(1)会类型转换为Double类型
        System.out.println(ob1);//输出1.0

        System.out.println(1);
    }
}
