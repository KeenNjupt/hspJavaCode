package com.keen.threaduse;

public class SellTicket {
    public static void main(String[] args) {
        //Thread子类的方式
//        new SellTicketA().start();
//        new SellTicketA().start();
//        new SellTicketA().start();
        //实现Runnable接口的方式
        SellTicketB sellTicketB = new SellTicketB();
        new Thread(sellTicketB).start();
        new Thread(sellTicketB).start();
        new Thread(sellTicketB).start();
    }
}

class SellTicketA extends Thread{
    static int tickets = 50; //所有对象共享该对象
    @Override
    public void run() {
        //多个线程同时对tickets时，不是原子化的，出现问题
        while(tickets > 0){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(String.format("窗口：%s, 卖出一张票，剩余票数：%d", Thread.currentThread().getName(), (--tickets)));
        }
    }
}

class SellTicketB implements Runnable{
    int tickets = 50; //使用代理模式时，多个线程使用同一个对象的资源
    @Override
    public void run() {
        //多个线程同时对tickets时，不是原子化的，出现问题
        while(tickets > 0){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(String.format("窗口：%s, 卖出一张票，剩余票数：%d", Thread.currentThread().getName(), (--tickets)));
        }
    }
}