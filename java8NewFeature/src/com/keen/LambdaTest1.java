package com.keen;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 * 1.举例：(o1,o2) -> Integer.compare(o1,o2)
 * 2.格式：
 *  -> ：Lambda操作符 或 箭头操作符
 *  箭头左边：Lambda形参列表，其实就是接口中抽象方法的形参列表
 *  箭头右边：Lambda体，其实就是重写的抽象方法的方法体
 *
 *  3.Lambda表达式的使用：6种情况介绍
 *  总结：
 *  箭头左边：Lambda形参列表的参数类型可以省略(类型推断)；如果只有一个形参则()也可以省略
 *  箭头右边：Lambda体，应该使用一对{}包裹，如果只有一条语句，可以省略{},如果是return语句 也省略return 关键字
 *
 *  4.Lambda表达式的本质：函数式接口的实例，即重写接口方法的类对象。
 *
 *  5.函数式接口：接口中只声明了一个抽象方法，可使用注解@FunctionalInterface声明
 *
 *  6.用匿名实现类表示的东西，可以使用Lambda表达式来实现
 */

public class LambdaTest1 {
    //语法格式1：无参，无返回值
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };

        r1.run();
        System.out.println("===========");
        //lambda表达式，简化匿名类重载函数的写法
        Runnable r2 = () -> {
            System.out.println("hi");
        };
        r2.run();
    }

    //语法格式2：单参，无返回值
    @Test
    public void test2(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("hello");
        System.out.println("====== ");
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("hi");
    }

    //语法格式3，参数类型可以省略，由编译器推断，称为"类型推断"
    @Test
    public void test3(){


        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("hi");
        System.out.println("====== ");

        Consumer<String> con2 = (s) -> {
            System.out.println(s);
        };
        con2.accept("hello");

    }

    //语法格式4：Lambda若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test4(){


        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("hello");


        Consumer<String> con2 = s -> {
            System.out.println(s);
        };
        con2.accept("hello");
    }

    //语法格式5：Lambda 需要两个或以上的参数时，多条执行语句，并且可以有返回值
    @Test
    public void test5(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("1");
                System.out.println("2");
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(1,2));
        System.out.println("=======");

        Comparator<Integer> com2 = (Integer o1, Integer o2) -> {
                System.out.println("1");
                System.out.println("2");
                return o1.compareTo(o2);
            };
        System.out.println(com2.compare(2,1));
    }

    //语法格式6：当Lambda体只有一条语句时，return 与大括号若有，都可以省略
    @Test
    public void test6(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(1,2));
        System.out.println("=======");

        Comparator<Integer> com2 = (Integer o1, Integer o2) ->  o1.compareTo(o2);

        System.out.println(com2.compare(2,1));

    }
}
