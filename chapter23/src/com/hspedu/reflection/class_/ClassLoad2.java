package com.hspedu.reflection.class_;

public class ClassLoad2 {
    public static void main(String[] args) throws Exception{
        /**1.A类加载
         * 2. A类链接 b初始化为0
         * 3. A类初始化，收集静态变量赋值和静态代码块中的语句，合并
         *synchronized (getClassLoadingLock(name))
         *  clinit(){ //clinit会被加锁，保证在多线程情况下类被正确的初始化,保证一个类在内存中只有一个Class对象
         *      System.out.println("静态代码块被执行");
         *      b = 30;
         *      b = 20;
         * }
         */

//        System.out.println(A.b);
        new A();

    }

}

//类加载分为三个阶段：
// 1.加载：将字节码文件加载到内存中
//2.链接：验证（验证字节码文件是否以魔数开始0xcafebabe）->准备->解析（jvm将符号引用替换为直接引用）
//3.类初始化:执行<clinit>()方法，编译器按语句在源文件中出现的顺序，收集静态变量赋值和静态代码块中的语句并合并

class A{
    //在链接的准备阶段，
    // a不是类相关的变量不会被分配内存，
    // b是类相关变量但会被默认初始化为0
    //c会被默认初始化为30

    static{
        System.out.println("静态代码块被执行");
        b = 30;
    }
    public int a = 10;
    public static int b = 20;
    public static final int c = 30;
}
