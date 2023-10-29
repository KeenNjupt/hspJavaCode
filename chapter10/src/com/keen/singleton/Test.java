package com.keen.singleton;

public class Test {
    public static void main(String[] args) {
//        A a = A.getInstance();
//        System.out.println(a);
//        A aa = A.getInstance();
//        System.out.println(aa);

//        int bf = B.bb;
        B b = B.getInstance();
        System.out.println(b);
        B b2 = B.getInstance();
        System.out.println(b2);
    }
}

class A{
    //单例模式,饿汉式(表示类实例在类加载时已创建，此时也许还未使用到该实例)
    //存在资源浪费问题
    private A(){ //构造函数私有化

    }
    private static A a = new A();//将实例声明为静态变量
    public static A getInstance(){ //通过静态方法得到该静态变量
        return a;
    }

}

class B{
    //单例模式-懒汉式(表示只有在调用返回实例的方法时，该对象才会被实例化)
    //懒汉式存在线程安全问题，即同步问题，多个线程在getInstance中对b==null判为true
    public static int bb = 0;
    private B(){
        System.out.println("in B()");
    }
    public static B b;
    public static B getInstance(){
        if(b == null){
            b = new B();
        }
        return b;
    }
}
