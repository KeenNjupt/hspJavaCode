package com.hspedu.reflection;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionUtils {

    @Test
    public void test1() throws Exception{
        //获取Class对象
        Class<?> personCls = Class.forName("com.hspedu.reflection.Person");
        //获取全类名
        System.out.println(personCls.getName());
        //获取简单类名
        System.out.println(personCls.getSimpleName());
        //获取所有public修饰的属性,包含本类和父类
        Field[] fields = personCls.getFields();
        for (Field field : fields) {
            System.out.println("本类及父类的public属性: " + field.getName());
        }
        //获取本类的所有属性
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类所有属性: " + declaredField.getName());
        }
        //获取所有public修饰的方法，包含本类和父类
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.println("本类和父类public方法: " + method.getName());
        }
        //获取本类的所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declareMethod : declaredMethods) {
            System.out.println("本类所有方法: " + declareMethod.getName());
        }

        //获取所有public修饰的构造器，本类的
        Constructor<?>[] constructors = personCls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("本类和父类public构造器: " + constructor.getName());
        }

        //获取本类所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类所有构造器: " + declaredConstructor.getName());
        }
        //以Package形式返回类所在的包信息
        System.out.println(personCls.getPackage());
        //以Class形式返回父类信息
        Class<?> superclass = personCls.getSuperclass();
        System.out.println("父类：" + superclass);
        //以Class[]形式返回接口信息
        Class<?>[] interfaces = personCls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口信息：" + anInterface);
        }
        //以Annotation[]形式返回注解信息
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息：" + annotation);
        }


    }

    @Test
    public void test02() throws Exception{
        //获取Class对象
        //通过Filed对象获取属性的修饰符级别 0,1,2,4表示default，public， private， protected
        //8表示static，final表示16 ,若既是public还是static则为1+8=9
        Class<?> personCls = Class.forName("com.hspedu.reflection.Person");
        //获取本类的所有属性，及属性的修饰符信息和属性类型
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类所有属性: " + declaredField.getName()
                    + ", 属性修饰符信息：" + declaredField.getModifiers()
                    + ", 属性的类型" + declaredField.getType());
        }
        //获取本类的所有方法，方法修饰符信息和返回类型，修饰符信息与Filed对象定义相同
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declareMethod : declaredMethods) {
            System.out.println("本类所有方法: " + declareMethod.getName()
            + ", 方法修饰符信息：" + declareMethod.getModifiers()
            + ", 方法返回值类型: " + declareMethod.getReturnType()
            + ", 方法参数类型数组" + Arrays.asList(declareMethod.getParameterTypes()));
        }

        //获取本类所有构造器以及构造器形参列表
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类所有构造器: " + declaredConstructor.getName()
            + ",形参列表：" + Arrays.asList(declaredConstructor.getParameterTypes()));
        }
    }
}

class A{
    public String hobby;
    public A(){

    }
    public void Am(){

    }
}

interface IA{

}

interface IB{

}

@Deprecated
class Person extends A implements IA, IB{
    public String name;
    protected int age;
    String job;
    private double sal;

    public Person(){

    }
    private Person(int i){

    }

    public void m1(String s, int i, Double d){

    }
    protected void m2(){

    }
    void m3(){

    }
    private void m4(){

    }
}
