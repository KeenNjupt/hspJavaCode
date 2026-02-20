package com.keen;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造器引用：
 * 和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致
 * 抽象方法的返回值类型即为构造器所属的类的类型
 *
 * 数组引用：
 * 可以把数组看作是一个特殊的类，则写法与构造器引用一致 String[]::new -> new String[10]
 */

public class ConstructorRefTest {

    //构造器引用
    //Supplier中的T get()
    //Employee的空参构造器: Employee()
    @Test
    public void test1(){
        Supplier<Employee> supplier = () -> new Employee();
        Employee employee = supplier.get();

        Supplier<Employee> supplier1 = Employee::new;
        Employee employee1 = supplier1.get();
    }

    //Function中的R apply(T t)
    //Employee的有参构造器：Employee(String name)
    @Test
    public void test2(){
        Function<String, Employee> function = (s) -> new Employee(s);
        Employee a = function.apply("a");
        System.out.println(a);

        Function<String, Employee> function1 = Employee::new;
        Employee b = function.apply("b");
        System.out.println(b);

    }

    //BiFunction中的R apply(T t, U u)
    //Employee的有参构造器 Employee(String name, Integer id)
    @Test
    public void test3(){
        BiFunction<String, Integer, Employee> biFunction = (name, id) -> new Employee(name, id);
        System.out.println(biFunction.apply("a",1));

        BiFunction<String, Integer, Employee> biFunction1 = Employee::new;
        System.out.println(biFunction1.apply("b",2));
    }

    //数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
        Function<Integer, String[]> function = (length) -> new String[length];
        System.out.println(Arrays.toString(function.apply(2)));

        Function<Integer, String[]> function1 = String[] :: new;
        System.out.println(Arrays.toString(function.apply(3)));

    }
}
