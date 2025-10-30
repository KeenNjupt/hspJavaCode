package com.hspedu.reflection;

import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflection01 {
    public static void main(String[] args) throws Exception {
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

        /**
         * 反射相关的类
         * java.lang.Class 表示类的结构的类
         * java.lang.reflect.Method 表示类的方法
         * java.lang.reflect.Field 表示类的成员变量
         * java.lang.reflect.Constructor 表示类的构造器
         */
        //获取Cat类中的age字段的Filed对象，不能获取private的字段
        Field ageField = cls.getField("age");
        //通过Field对象获取Cat类对象中该字段
        Object age = ageField.get(o);
        System.out.println(age);

        //获取Cat类中的构造器
        //获取无参构造器
        Constructor<?> constructor = cls.getConstructor();
        System.out.println(constructor);
        //获取有参构造器, Cat(String), 传入String的Class对象
        Constructor<?> constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);
    }
}
