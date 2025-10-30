package com.hspedu.reflection;

import java.lang.reflect.Method;

public class ReflectAccessMethod {
    public static void main(String[] args) throws Exception{
        Class<?> cls = Class.forName("com.hspedu.reflection.Boss");
        Object o = cls.newInstance();
        Method hi = cls.getDeclaredMethod("hi", String.class);
        hi.invoke(o, "aaa");
        //private方法
        Method say = cls.getDeclaredMethod("say", int.class, String.class, char.class);
        say.setAccessible(true);
        Object val = say.invoke(o, 1, "aaa", 'x'); //返回值编译类型统一为Object对象
        System.out.println(val);
        System.out.println(say.invoke(null, 1, "aaa", 'x')); //因为是static方法，传入对象可以为空

    }
}

class Boss{
    public int age;
    private static String name;
    private static String say(int i, String s, char c){
        return i + " " + s + " " + c;
    }
    public void hi(String s){
        System.out.println("hi " + s);
    }
}
