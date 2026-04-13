package com.keen.bean;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Consumer;

public class Java11NewFeature {

    /**
     * java11新特性：String中新增的方法
     */
    @Test
    public void test1(){
        //isBlank 判断字符串是否为空白
        System.out.println("   \t    \t    \n ".isBlank());
        //strip 去除首尾空白
        System.out.println("--------" + "   \t  abc\t  \n".strip() + "---------");
        //stripTrailing 去除尾部空白
        System.out.println("--------" + "   \t  abc\t  \n".stripTrailing() + "---------");
        //stripLeading 去除首部空白
        System.out.println("--------" + "   \t  abc\t  \n".stripLeading() + "---------");
        //repeat(int count) 重复
        System.out.println("abc".repeat(3));
        //lines.count() 返回有多少行数据
        System.out.println("abc\ncdf".lines().count());

    }

    /**
     * java11新特性：Optional新增方法
     */
    @Test
    public void test2(){
        var empty = Optional.empty();
        //判断内部的value是否存在
        System.out.println(empty.isPresent());
        //判断内部的value是否为空
        System.out.println(empty.isEmpty());

        empty = Optional.of("abc");
        //orElseThrow: value非空则返回value，否则抛异常 NoSuchElementException
        var obj = empty.orElseThrow();

        System.out.println(obj);


        Optional<String> hello = Optional.of("hello");
        //Optional<T> or(Supplier<? extends Optional<? extends T>> supplier)
        //若Optional对象非空则直接返回对象自身，若为空则返回传入的形参中supplier函数式接口的返回Optional对象
        empty = Optional.empty();
        Optional<Object> or = empty.or(() -> hello);
        System.out.println(or);

    }


    /**
     * java11新特性：局部变量类型推断的升级
     */
    @Test
    public void test3(){
        //错误的形式：必须要有类型，可以加上var
//        Consumer<String> con1 = (@Deprecated t) -> System.out.println(t.toUpperCase());
        //正确的形式：
        //使用var的好处是在使用Lambda表达式时给参数加上注解
        Consumer<String> con2 = (@Deprecated var t) -> System.out.println(t.toUpperCase());
    }

    /**
     * java11新特性：可以直接通过 java helloworld.java 执行
     * 要求1：第一个类必须由main方法
     * 要求2：不能调用其他文件中的类
     */
}
