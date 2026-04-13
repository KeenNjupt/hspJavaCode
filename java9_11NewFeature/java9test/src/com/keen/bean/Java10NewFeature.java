package com.keen.bean;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Java10NewFeature {

    /**
     * 局部变量类型推断
     * 原理：编译器先查看表达式右边部分，根据右边变量值的类型进行推断，作为左边变量的类型，然后将该类型写入字节码当中
     *
     * var不是关键字
     */

    @Test
    public void test1(){
        //声明变量时，根据所赋的值，推断变量的类型
        var num = 10;

        var stringArrayList = new ArrayList<String>();
        stringArrayList.add("1");

        for( var i : stringArrayList){
            System.out.println(i);
            System.out.println(i.getClass());
        }
    }

    @Test
    public void test2(){
        //1. 局部变量不赋值，就不能实现类型推断
//        var num;

        //2. lambda表达式中，左边的函数式接口不能声明为var
        Supplier<Double> sup = () -> Math.random();
//        var sup1 = () -> Math.random();

        //3. 方法引用中，左边的函数式接口不能声明为var
        Consumer<String> con = System.out::println;
//        var con1 = System.out::println;

        //4. 数组的静态初始化中，注意如下情况也不可以
        int[] arr = new int[]{1,2};
        int[] arr1 = {1,2};
        var arr2 = new int[]{3,5};
//        var arr3 = {3,5};
    }

    @Test
    public void test3(){
        //方法的返回类型不能使用var 无法判断返回类型是否正确
        //方法的参数类型不能使用var
        //类的属性不能使用var
        //catch块中不能使用var
    }

    //java10的新特性：集合中新增的copyOf(),用于创建一个只读的集合
    @Test
    public void test4(){
        var list = List.of("java", "c");
        //只读集合 不能修改
//        list.add("python");
        var copy1 = List.copyOf(list);
        System.out.println(list == copy1); //true

        var list2 = new ArrayList<String>();
        list2.add("python");
        var copy2 = List.copyOf(list2);
        System.out.println(list2 == copy2); //false
        //copyOf(Xxx coll): 如果参数coll本身就是一个只读集合，则copyOf()返回值即为当前集合
        //如果参数coll不是只读集合，则返回值为新的只读集合

    }
}
