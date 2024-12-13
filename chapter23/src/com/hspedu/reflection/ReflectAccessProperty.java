package com.hspedu.reflection;

import java.lang.reflect.Field;

public class ReflectAccessProperty {
    public static void main(String[] args) throws Exception{
        Class<?> cls = Class.forName("com.hspedu.reflection.Student");
        Object o = cls.newInstance();
        //得到属性对象
        Field age = cls.getField("age");
        age.set(o, 10); //设置对象中的属性值
        System.out.println(age.get(o));
        //得到非public的属性
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);//对name进行暴破
        name.set(o, "aa");
        System.out.println(name.get(o));
        name.set(null, "bb");//因为name是static，不传入对象也可以
        System.out.println(name.get(null));//因为name是static，不传入对象也可以

    }
}

class Student{
    public int age;
    private static String name;
    public Student(){

    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age + ", name=" + name +
                '}';
    }
}
