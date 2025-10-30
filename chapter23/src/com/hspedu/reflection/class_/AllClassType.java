package com.hspedu.reflection.class_;

import java.io.Serializable;

public class AllClassType {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Class<Serializable> serializableClass = Serializable.class;//接口
        Class<Integer> integerClass = Integer.class;
        Class<float[][]> aClass = float[][].class;
        Class<Deprecated> deprecatedClass = Deprecated.class;//注解
        Class<Thread.State> stateClass = Thread.State.class;
        Class<Void> voidClass = void.class;
        Class<Class> classClass = Class.class;
        Class<Long> longClass = long.class;

        System.out.println(stringClass);
        System.out.println(serializableClass);
        System.out.println(integerClass);
        System.out.println(aClass);
        System.out.println(deprecatedClass);
        System.out.println(stateClass);
        System.out.println(voidClass);
        System.out.println(classClass);
        System.out.println(longClass);
    }
}
