package com.keen;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 * 1.使用场景：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 * 2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以方法引用，
 * 也是函数式接口的实例
 * 3.使用格式：类（或对象）::方法名
 * 4.具体分为如下的三种情况：
 * 情况1  对象::非静态方法
 * 情况2  类::静态方法
 *
 * 情况3  类::非静态方法
 *
 * 5.方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和
 * 返回值类型相同(主要适用于情况1和情况2)
 */

public class MethodRefTest {


    //情况一：对象::实例方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test1(){
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("lambda");
        PrintStream printStream = System.out;
        Consumer<String> consumer1 = printStream::println;
        consumer1.accept("ref");
    }

    //Supplier中的T get()
    //Employee中的 String getName()
    @Test
    public void test2(){
        Employee employee = new Employee("name");
        Supplier<String> supplier = () -> employee.getName();
        System.out.println(supplier.get());
        Supplier<String> supplier1 = employee::getName;
        System.out.println(supplier1.get());
    }

    //情况二：类::静态方法
    //Comparator中的int compare(T t1, T t2)
    //Integer中的int compare(T t1, T t2)
    @Test
    public void test3(){
        Comparator<Integer> comparator = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(comparator.compare(11,22));

        Comparator<Integer> comparator1 = Integer::compareTo;
        System.out.println(comparator1.compare(22,11));
    }

    //Function 中的 R apply(T t)
    //Math中的Long round(Double d)
    @Test
    public void test4(){
        Function<Double, Long> function = (d) -> Math.round(d);
        System.out.println(function.apply(2.1));

        Function<Double, Long> function1 = Math::round;
        System.out.println(function1.apply(3.1));
    }

    //情况3：类::非静态方法
    //Comparator 的 int compare(T t1, T t2)
    //String 的 int t1.compareTo(t2)
    @Test
    public void test5(){
        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
        System.out.println(comparator.compare("a", "b"));
        //compare方法需要两个参数，String::compareTo表示，第一个String为第一个参数类型，
        // compareTo表示第一个参数类型的对象t1调用compareTo函数并传入第二个对象t2 t1.compareTo(t2)
        Comparator<String> comparator1 = String::compareTo;
        System.out.println(comparator1.compare("a","d"));
    }

    //BiPredicate中的 boolean test(T t1, T t2)
    //String中的 boolean t1.equals(t2)
    @Test
    public void test6(){
        BiPredicate<String, String> biPredicate = (s1, s2) -> s1.equals(s2);
        System.out.println(biPredicate.test("a","a"));

        BiPredicate<String, String> biPredicate1 = String::equals;
        System.out.println(biPredicate1.test("a","b"));
    }

    //Function中的R apply(T t)
    //Employee中的String getName()
    @Test
    public void test7(){
        Function<Employee, String> function = (e) -> e.getName();
        Employee employee = new Employee("aaa");
        System.out.println(function.apply(employee));
        //Employee::getName Employee表示apply参数类型为Employee
        //getName表示方法体为t.getName()
        Function<Employee, String> function1 = Employee::getName;
        System.out.println(function1.apply(employee));
    }
}

class Employee{
    String name;
    Integer id;
    Integer age;

    public Employee(){

    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, Integer id, Integer age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }
    public Employee(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}