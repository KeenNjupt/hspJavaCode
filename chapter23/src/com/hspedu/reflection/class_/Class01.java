package com.hspedu.reflection.class_;

import com.hspedu.Cat;
import sun.reflect.Reflection;

public class Class01 {
    //介绍Class类
    public static void main(String[] args) throws Exception{
        //1. Class类也继承Object类，与普通类无差异
        //2. Class类对象不是new出来的，而是系统自动生成的
        //加载类时，由ClassLoader类型的loadClass方法生成
        //2.1 传统方式：
        /**
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return loadClass(name, false);
        }
         **/
//        Cat cat = new Cat();
        //2.2 反射方式, 对于一个类型，只会生成一个Class类对象，如果之前生成过，便不会再次生成
        /**
        再进入forName0时会进入loadClass
        public static Class<?> forName(String className)
                throws ClassNotFoundException {
            Class<?> caller = Reflection.getCallerClass();
            return forName0(className, true, ClassLoader.getClassLoader(caller), caller);
        }
         **/
        Class<?> cls = Class.forName("com.hspedu.Cat");
        //3.对于一个类型，内存中只会生成一个Class类对象
        Class<?> cls1 = Class.forName("com.hspedu.Cat");
        System.out.println(cls.hashCode() + ", " + cls1.hashCode());
        System.out.println(cls == cls1);
        //4. 每一个类的对象都记得它是由哪个Class对象生成的
        Object o = cls.newInstance();
        System.out.println(o.getClass());
        //5. 通过Class对象的一系列方法可以获得一个类的完整结构
        //6. Class对象存放在堆中
        //7. 编译后的类字节码二进制数据，放在方法区中
    }
}
