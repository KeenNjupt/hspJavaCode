package com.keen.innerclasstest;

public class LocalInnerClass {
    public static void main(String[] args) {
        new A().m();
    }
}

class A{
    private int n1 = 10;
    public void m(){
        //局部内部类定义在方法或代码块中
        //作用域在方法体或代码块中，因为是局部变量，不能添加访问修饰符
        //本质上是一个类
        //若在内部类中访问与外部类中同名的成员，就近原则，可用外部类名.this.成员指定要访问外部类的成员
        class inner{
            private int n1 = 80;
            public void f(){
                System.out.println("内部类的n1 = "+ n1 + ", 外部类的n1 = " + A.this.n1);
            }
        }
        new inner().f();
    }
}
