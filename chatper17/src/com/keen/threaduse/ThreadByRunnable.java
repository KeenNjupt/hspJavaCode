package com.keen.threaduse;

public class ThreadByRunnable {
    public static void main(String[] args) {
        /**下面这种方式为代理设计模式
         * 即由Thread实现多线程，但子线程在执行run方法时使用自定义类的run方法
         * Thread类型中的run方法如下，target为Runnable接口对象
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
