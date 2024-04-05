package com.keen.threadexercise;

public class WithDrawTest {
    public static void main(String[] args) {
        Count count = new Count(10000);
        Thread thread = new Thread(count);
        thread.setName("用户A");
        thread.start();
        Thread thread1 = new Thread(count);
        thread1.setName("用户B");
        thread1.start();
    }
}

class Count implements Runnable{
    private int balance;
    public Count(int balance){
        this.balance = balance;
    }
    private synchronized void withDraw(int amount){ //在this对象上加锁，synchronized实现的锁机制是非公平锁
        if(this.balance >= amount) {
            this.balance -= amount;
            System.out.println(String.format("%s取出%d, 当前余额为：%d",Thread.currentThread().getName(), amount, balance));
        }
        else {
            System.out.println(String.format("%s余额不足，无法取出, 当前余额为：%d", Thread.currentThread().getName(), balance));
        }
    }
    @Override
    public void run() {
        while (true){
            withDraw(1000);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


