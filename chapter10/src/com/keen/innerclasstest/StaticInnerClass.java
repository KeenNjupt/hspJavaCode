package com.keen.innerclasstest;

public class StaticInnerClass {
    public static void main(String[] args) {
        new AB().func();
        //外部其他类访问静态内部类中两种方式
        //1.直接创建对象
        AB.ABS abs = new AB.ABS();
        abs.f();
        //2.在外部类中实现一个返回静态内部类实例的方法
        AB.ABS absInstance = new AB().getABSInstance();
        absInstance.f();

    }
}

class AB{
    private int n = 20;
    private static int n2 = 30;

    //静态内部类可以访问类中静态成员，不能访问非静态成员
    public static class ABS{
        private int n2 = 40;
        //静态内部类中访问与外部类同名的成员，采用就近原则
        //若要访问外部类的成员，使用外部类名.成员
        public void f(){
            System.out.println("内部类n2 = " + n2);
            System.out.println("外部类n2 = " + AB.n2);
//            System.out.println(n1);
        }
    }

    //在外部类中访问内部类成员，可以先创建对象再访问
    public void func(){
        ABS abs = new ABS();
        abs.f();
    }
    public ABS getABSInstance(){
        return new ABS();
    }
}
