package com.hspedu.reflection.question;

import com.hspedu.Cat;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //创建一个com.hspedu.Cat类型的对象 并调用hi方法

        //常规方法
        Cat cat = new Cat();
        cat.hi();
        /**
         * java程序在计算机中的三个阶段
         * 1. 代码编译阶段，编写.java文件，通过 javac 命令编译.java文件生成.class文件
         * 2.使用java命令运行.class文件时，首先进入类加载阶段，类加载器(ClassLoader)将.class文件加载至堆中
         * 即生成该类对象的Class对象，该对象中包含成员Field[] fields(表示该类的成员变量)
         * Constructor[] cons(表示该类的构造器)、Method[] ms(表示该类的成员方法)
         * 3. 类加载后，开始运行代码：类的对象可以获得对应类的Class对象，可以通过Class对象创建该类的对象，调用方法等操作
         */

        /**
         *java加载完类后，在堆中产生了一个Class类型的对象，一个类只有一个Class对象
         * 该Class对象包含类的完整结构信息，该对象犹如一面镜子，显示出类的结构，称为反射
         */
        //使用配置文件，加载相应的类，调用相应的方法
        Properties properties = new Properties();
        properties.load(new FileReader("src\\re.properties"));
        String classfullpath = properties.getProperty("classfullpath");
        String methodName = properties.getProperty("method");
        //符合设计模式中的开闭原则，即通过修改配置文件，而不是源码来控制程序的行为
        //使用反射机制，生成对象，调用对应的方法
        //加载classfullpath对应的类，返回Class对象
        Class<?> cls = Class.forName(classfullpath);
        //获取classfullpath对应类的对象
        Object o = cls.newInstance();
        //获取methodName对应的方法对象，得到classfullpath对应类的methodName方法对象
        Method method = cls.getMethod(methodName);
        //调用方法，通过方法对象来实现调用方法，传统方法为：对象.方法() 实际执行的是方法(对象this引用)
        // 反射：方法对象.invoke(对象)
        method.invoke(o);
    }
}
