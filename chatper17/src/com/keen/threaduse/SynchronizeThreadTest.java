package com.keen.threaduse;

public class SynchronizeThreadTest {
    public static void main(String[] args) {

        SellTicketC sellTicketC = new SellTicketC();
        new Thread(sellTicketC).start();
        new Thread(sellTicketC).start();
        new Thread(sellTicketC).start();
    }
}
class SellTicketC implements Runnable{
    static int tickets = 50; //使用代理模式时，多个线程使用同一个对象的资源
    static boolean loop = true;
    Object obj = new Object();
    //使用synchronized关键字表示同一时刻只有一个线程可以调用该函数
    /**java中引入了互斥锁的概念，锁是加在对象上的
     *每个对象有一个互斥锁标记，保证任何时刻只有一个线程访问该对象
     *
     * synchronized(对象){ 得到对象的锁，才能执行同步代码块
     * 需要被同步的代码块
     * }
     * 如void m(){
     *      synchronized（obj）{ 锁加在obj上
     *
     *      }
     * }
     * synchronized void m(){ 方法为同步方法，同一时刻只能有一个线程调用该方法，锁加在this对象上
     *}
     */

    /**注意事项：分析上锁代码块，优先使用同步代码块，范围越小越好
     *要求多个线程的锁对象为同一个才会起作用，即new Thread子类().start这种方式启动线程，多个线程的对象不是同一个
     * 在方法中加synchronized，默认锁this对象，this对象多个线程不是一个对象，互斥锁不会起作用
     */

    static synchronized void f(){ //对于静态方法，锁加在SellTicket.class对象上
        synchronized (SellTicket.class){ //静态方法代码块，需要锁加在SellTicket.class对象上

        }
    }
    synchronized void sell(){
        if(tickets < 1) {
            loop = false;
            System.out.println(String.format("窗口：%s, 售票结束，剩余票数: %d", Thread.currentThread().getName(), (tickets)));
            return;
        }
        synchronized (this) { //在代码块中加锁，锁加在this对象上

            System.out.println(String.format("窗口：%s, 卖出一张票，剩余票数：%d", Thread.currentThread().getName(), (--tickets)));
        }
        synchronized (obj) { //在代码块中加锁，锁加在obj对象上,要求多线程访问该代码块时，必须是同一个obj对象

            System.out.println(String.format("窗口：%s, 剩余票数：%d", Thread.currentThread().getName(), (tickets)));
        }
    }
    @Override
    public void run() {
        //多个线程同时对tickets时，不是原子化的，出现问题
        while(loop){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sell();
        }
    }
}
