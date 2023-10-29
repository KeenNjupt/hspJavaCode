package com.keen.innerclasstest;

public class MemberInnerClass {
    public static void main(String[] args) {
        new A3().g();
        //外部其他类，使用成员内部类的两种方式
        //1.
        A3.Ai ai = new A3().new Ai();
        ai.f();
        //2.利用外部类中返回内部类实例的方法
        A3.Ai ai1 = new A3().getAiInstance();
        ai1.f();
    }
}

class A3{
    private int a = 10;
    //成员内部类，类定义在成员位置上，内部类可以访问外部类中的成员
    public class Ai{
        private int a = 20;
        //静态内部类中访问与外部类同名的成员，采用就近原则
        //若要访问外部类的成员，使用外部类名.this.成员
        public void f(){
            System.out.println("内部类a = " + a);
            System.out.println("外部类a = " + A3.this.a);
        }
    }
    public void g(){
        Ai ai = new Ai();
        ai.f();
    }
    //该方法返回内部类Ai的实例
    public Ai getAiInstance(){
        return new Ai();
    }
}
