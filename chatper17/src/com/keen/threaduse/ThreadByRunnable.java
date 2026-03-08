package com.keen.threaduse;

public class ThreadByRunnable {
    public static void main(String[] args) {
        /**下面这种方式为代理设计模式
         *使用代理将对象包装起来，使用该代理对象取代原始对象。任何对原始对象的调用都要通过代理，
         * 代理对象决定是否以及何时将方法调用转到原始对象上
         * 即由Thread实现多线程，但子线程在执行run方法时使用自定义类的run方法
         * Thread类型中的run方法如下，target为Runnable接口对象 Thread是代理对象，Runnable接口对象是原始对象
         * public void run() {
         *     if (target != null) {
         *         target.run();
         *     }
         * }
         * target对象由Thread对象初始化时赋值为传入的参数
         * public Thread(Runnable target) {
         *     init(null, target, "Thread-" + nextThreadNum(), 0);
         * }
         *
         */

        /**
         * 上述代理模式为静态代理
         * 静态代理的缺点：
         * 代理类和目标对象类都是在编译期间确定下来，不利于程序的扩展
         * 每一个代理类只能为一个接口服务，这样导致程序开发中必然产生过多的代理
         */
        Dog dog = new Dog();
        Thread thread = new Thread(dog);
        thread.start();
        for(int i = 0; i < 5; ++i) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("in main : " + Thread.currentThread().getName());
        }
    }
}

/**
 * 对于已经有父类的类，它无法继承Thread类，可以通过实现Runnable接口来实现多线程
 */
class Dog implements Runnable{
    int times = 0;
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(times < 10) {
                System.out.println("in Dog, times is  " + (++times) + " " + Thread.currentThread().getName());
            }
            else{
                break;
            }
        }
    }
}
