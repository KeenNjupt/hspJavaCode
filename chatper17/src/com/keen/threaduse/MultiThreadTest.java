package com.keen.threaduse;

public class MultiThreadTest {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread = new Thread(t1);
        Thread thread1 = new Thread(t2);
        thread.start();
        thread1.start();

    }
}

class T1 implements Runnable{
    int times = 0;
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(times < 40) {
                System.out.println("in T1, times is  " + (++times) + " " + Thread.currentThread().getName());
            }
            else{
                break;
            }
        }
    }
}
class T2 implements Runnable{
    int times = 0;
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(times < 30) {
                System.out.println("in T2   , times is  " + (++times) + " " + Thread.currentThread().getName());
            }
            else{
                break;
            }
        }
    }
}