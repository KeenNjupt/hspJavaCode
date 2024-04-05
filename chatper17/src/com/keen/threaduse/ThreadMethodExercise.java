package com.keen.threaduse;

public class ThreadMethodExercise {
    public static void main(String[] args) {
        TC tc = new TC();
        Thread thread = new Thread(tc);


        for (int i = 1; i < 11; ++i){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hi " + i);
            if( i == 5){
                try {
                    thread.start();//启动子线程
                    thread.join();//先让子线程执行完成
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.println("主线程结束...");
    }
}

class TC implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i < 11; ++i){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hello " + i);
        }

        System.out.println("子线程结束...");
    }
}
