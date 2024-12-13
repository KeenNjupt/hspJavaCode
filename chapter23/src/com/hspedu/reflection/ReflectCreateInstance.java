package com.hspedu.reflection;

import java.lang.reflect.Constructor;

public class ReflectCreateInstance {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("com.hspedu.reflection.User");
        //使用无参构造器创建对象
        Object o = cls.newInstance();
        //使用有参构造器创建对象,获取参数列表为String的构造器
        Constructor<?> constructor = cls.getConstructor(String.class);
        Object o1 = constructor.newInstance("a"); //将"a"作为参数传入构造器中创建对象
        System.out.println(o1);
        //使用私有的构造器创建对象
        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(int.class, String.class);
        declaredConstructor.setAccessible(true);//暴破，即使访问控制失效，可以使用private的构造器
        Object o2 = declaredConstructor.newInstance(1, "b");
        System.out.println(o2);
    }
}


class User{
    private int age;
    private String name;
    public User(){
        System.out.println("in public User()");
    }
    public User(String name){
        this.name = name;
    }
    private User(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
