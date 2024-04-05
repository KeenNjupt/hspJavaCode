package com.keen.threaduse;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadMethod {
    public static void main(String[] args) {
//        TA ta = new TA();
//        ta.setName("keen");
//        ta.start();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("中断线程");
//        ta.interrupt();//并不会终止线程，只是将线程从休眠状态（sleep）中唤醒
        TB tb = new TB();
        tb.start();
        for(int i = 0; i < 10; ++i){
            try {
                Thread.sleep(1000);
                System.out.println("in " + Thread.currentThread().getName() + " " + i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(i == 5){
//                try {
                    System.out.println("让子线程先执行完毕");
//                    tb.join(); //线程插队，表示先让tb子线程执行完毕，再执行当前线程
                    Thread.yield();//线程yield，表示先让别的线程执行，cpu判断是否真正进行线程切换
//                }
//                catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
        }

        System.out.println("main线程退出");
    }
}

class TA extends Thread{
    private int count = 0;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(2000);
                System.out.println("count = " + (++count) + " " + currentThread().getName());
                System.out.println("当前时间为：" + sdf.format(new Date()));
            } catch (InterruptedException e) {
                System.out.println(String.format("线程%s 被中断", getName()));
            }
        }
    }
}
class TB extends Thread{
    private int count = 0;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
    @Override
    public void run() {
        while(count < 10){
            try {
                Thread.sleep(1000);
                System.out.println(currentThread().getName() + ", count = " + (++count));
            } catch (InterruptedException e) {
                System.out.println(String.format("线程%s 被中断", getName()));
            }
        }
    }
}