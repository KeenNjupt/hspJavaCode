package com.hspedu.reflection;

import com.hspedu.Cat;

import java.lang.reflect.Method;

public class Reflection02 {

    /**
     * 使用反射调用方法时，为解释执行，速度较慢
     * 可以通过对Method、Field、Constructor对象执行 setAccessible(true)方法
     * 表示反射对象在使用时，取消访问检查，提高反射效率
     *
     */

    public static void main(String[] args) throws Exception {
        Reflection02 reflection02 = new Reflection02();
        reflection02.m1();
        reflection02.m2();
        reflection02.m3();
    }
    //传统方法
    public void m1(){
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        int cnt = 1000000000;
        for(int i = 0; i < cnt; ++i){
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("in m1 time is " + (end - start));
    }
    //反射方法
    public void m2() throws Exception{
        Class<?> cls = Class.forName("com.hspedu.Cat");
        Object o = cls.newInstance();
        Method hiMethod = cls.getMethod("hi");
        long start = System.currentTimeMillis();
        int cnt = 1000000000;
        for(int i = 0; i < cnt; ++i){
            hiMethod.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("in m2 time is " + (end - start));
    }
    //反射优化，关闭访问检查
    public void m3() throws Exception{
        Class<?> cls = Class.forName("com.hspedu.Cat");
        Object o = cls.newInstance();
        Method hiMethod = cls.getMethod("hi");
        hiMethod.setAccessible(true);
        long start = System.currentTimeMillis();
        int cnt = 1000000000;
        for(int i = 0; i < cnt; ++i){
            hiMethod.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("in m3 time is " + (end - start));
    }
}
