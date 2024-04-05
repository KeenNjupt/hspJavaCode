package com.keen.threaduse;

public class ThreadStateTest {
    public static void main(String[] args) {
        //Thread.State几种状态
        //new 一个线程对象时，该线程状态为NEW
        //线程对象调用start方法时，该线程状态为RUNNABLE，该状态细分为Ready就绪状态和Running运行状态，由调度器控制
        //运行的线程对象调用yield方法时，状态会转成Ready，但可能又被调度器调起执行
        //线程对象调用sleep(time)，wait(time)，join(time)方法时该线程转为Timed_Waiting状态，时间结束后线程转为RUNNABLE
        //线程对象调用wait(), join()方法时，该线程转为Waiting状态，线程调用notify()时转为RUNNABLE
        //线程对象等待获取锁时，进入BLOCKED

        ThreadS threadS = new ThreadS();
        System.out.println(threadS.getName() + " 状态为：" + threadS.getState());
        threadS.start();
        System.out.println(threadS.getName() + " 状态为：" + threadS.getState());
        while(Thread.State.TERMINATED != threadS.getState()){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(threadS.getName() + " 状态为：" + threadS.getState());

        }
    }
}

class ThreadS extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; ++i){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hello " + i);
        }

    }
}
