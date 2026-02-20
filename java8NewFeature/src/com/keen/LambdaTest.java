package com.keen;

import org.junit.Test;

import java.util.Comparator;

public class LambdaTest {
    public static void main(String[] args) {

    }
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
        Runnable r2 = () -> System.out.println("hi");
        r2.run();
    }

    @Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(com1.compare(12, 20));
        System.out.println("============");
        //lambda表达式，简化匿名类重载函数的写法
        Comparator<Integer> com2 = (o1, o2) ->  Integer.compare(o1, o2);
        System.out.println(com2.compare(20,12));
        System.out.println("============");
        //方法引用
        Comparator<Integer> com3 = Integer::compare;
        System.out.println(com2.compare(20,12));
    }
}
