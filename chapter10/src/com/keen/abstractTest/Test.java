package com.keen.abstractTest;

public class Test {
    public static void main(String[] args) {
//        new Animal();//抽象类不能被实现
        Manager kk = new Manager("kk", 2, 1);
        kk.worker();
        Staff ll = new Staff("ll", 10, 2);
        ll.worker();
    }
}

abstract class Animal{ //若类中包含抽象方法，则要将该类声明为抽象类
    public abstract void eat(); //声明为抽象方法，表示该方法没有方法体，让子类来实现
}

abstract class A{ //抽象类可以没有抽象方法，并且可以有非抽象方法
    public void f(){

    }
}

class cat extends Animal{ //抽象类的子类要么实现抽象类中的所有抽象方法，要么声明为抽象类
    @Override
    public void eat() {

    }
}

abstract class B{
    //private, final, static 不能修饰abstract方法
//    private abstract void f();
//    public final abstract void g();
//    public static abstract void h();
}

abstract class Employee{
    private String name;
    private int age;
    private double salary;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public abstract void worker();
}

class Staff extends Employee{
    public Staff(String name, int age, double salary) {
        super(name, age, salary);
    }

    @Override
    public void worker() {
        System.out.println(getName() + " staff is working");
    }
}

class Manager extends Employee{
    public Manager(String name, int age, double salary) {
        super(name, age, salary);
    }

    @Override
    public void worker() {
        System.out.println(getName() + " the manager is working");
    }
}
