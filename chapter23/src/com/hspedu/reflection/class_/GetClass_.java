package com.hspedu.reflection.class_;

import com.hspedu.Car;

/**
 * 演示得到Class对象的四种方法
 */
public class GetClass_ {
    public static void main(String[] args) throws Exception{

        //1. 已知全类名，且该类在类路径下，可通过Class类的静态方法forName获取。编译阶段
        //多用于配置文件，读取类全路径名，加载类
        String catClassPath = "com.hspedu.Car";
        Class<?> cls1 = Class.forName(catClassPath);
        System.out.println(cls1);
        //2. 类名.class, 多用于将Class对象作为参数传递。类加载阶段
        System.out.println(Car.class);
        //3.对象.getClass , 多用于有对象时, 运行时阶段
        Car car = new Car();
        System.out.println(car.getClass());
        //4. 通过类加载器来获取类的Class对象
        ClassLoader classLoader = car.getClass().getClassLoader();
        Class<?> cls2 = classLoader.loadClass(catClassPath);
        System.out.println(cls2);

        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        //5. 对于基本数据类型(int, float)，通过数据类型.class获取
        Class<Integer> integerClass = int.class;
        System.out.println(integerClass);
        //6. 对于基本类型的包装类，可通过类型.TYPE获取Class对象
        Class<Integer> type = Integer.TYPE;
        System.out.println(type); //int
        System.out.println(integerClass.hashCode());
        System.out.println(type.hashCode());
    }
}
