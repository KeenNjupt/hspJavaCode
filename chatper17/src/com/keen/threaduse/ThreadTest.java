package com.keen.threaduse;

/**创建线程的两种方式：1. 继承Thread类，2.实现Runnable接口
 * 重写run方法，自定义自己的业务逻辑
 */
public class ThreadTest{
    public static void main(String[] args) {
        //程序开始运行时启动一个进程,启动一个主线程：main线程
        System.out.println("main函数中的线程为：" + Thread.currentThread().getName());
        Cat cat = new Cat();
        //cat.start方法执行时，又启动一个子线程：使用Thread.currentThread().getName()获得当前线程的名字
        cat.start(); //start方法会调用cat的run方法, Thread.start()->private native void start0();
        //start0是本地方法，由JVM机调用，底层是c/c++实现，创建一个子线程，将其状态设置为可执行，等待操作系统调起
        //若直接调用cat.run方法，还是在main线程中执行，没有启动子线程，程序会阻塞在cat.run方法，直到它执行结束
//        cat.run();
        //main线程不会阻塞在cat.start产生的线程，即会继续执行。并且main线程结束后，其他子线程会继续运行
        //所有子线程运行结束后，该程序进程才会结束
        //可以在终端使用jconsole查看线程情况
        for(int i = 0; i < 60; ++i) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("continue main: " + i);
        }
        System.out.println("main finish");
    }
}

//1.当一个类继承了Thread类，该类可以当作线程使用
//2.我们可以重写run方法，写上自己的业务逻辑
//3.run方法来源于Runnable接口，Thread类实现了该接口
//Thread类中的run方法如下
//public void run() {
//    if (target != null) {
//        target.run();
//    }
//}
class Cat extends Thread{
    int times = 0;
    @Override
    public void run() {
    //每隔一秒，输出"hello,world"
        while(true) {
            System.out.println(String.format("%d:hello, world, 线程名称为：%s",times++, Thread.currentThread().getName() ));
            try {
                //睡眠，sleep是一个native方法，表示该方法是由非java语言实现的
                Thread.sleep(1000);//1000ms
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(times == 10){
                break;
            }
        }
    }
}
