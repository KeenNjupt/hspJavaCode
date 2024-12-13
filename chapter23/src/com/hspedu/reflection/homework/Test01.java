package com.hspedu.reflection.homework;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test01 {
    public static void main(String[] args) throws Exception{
        PrivateTest privateTest = new PrivateTest();
        Class<?> aClass = Class.forName("com.hspedu.reflection.homework.PrivateTest");
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(privateTest, "keen");
        System.out.println("name.getName = " + privateTest.getName());
        System.out.println("=====");
        Method method = aClass.getMethod("getName");
        System.out.println("method.invoke = " + method.invoke(privateTest));


        Class<?> fileCls = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = fileCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        Constructor<?> declaredConstructorString = fileCls.getDeclaredConstructor(String.class);
        Object file = declaredConstructorString.newInstance("E:\\mynew.txt");
        Method methodCreate = fileCls.getMethod("createNewFile");
        methodCreate.invoke(file);

    }
}

class PrivateTest{
    private String name = "hellokitty";
    public String getName(){
        return name;
    }
}
