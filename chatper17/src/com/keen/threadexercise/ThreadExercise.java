package com.keen.threadexercise;

import java.util.Random;
import java.util.Scanner;

public class ThreadExercise {
    public static void main(String[] args) {
        T t = new T();
        TA ta = new TA(t);
        new Thread(t).start();
        new Thread(ta).start();

    }
}

class T implements Runnable{
    Boolean loop = true;
    Random r = new Random();
    @Override
    public void run() {
        while(loop){
            System.out.println(r.nextInt(100));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Boolean getLoop() {
//        synchronized (this.loop) {
            return loop;
//        }
    }

    public void setLoop(Boolean loop) {
//        synchronized (this.loop) {
            System.out.println("in setLoop");
            this.loop = loop;
//        }
    }
}

class TA implements Runnable{
    private T t;
    Scanner scanner = new Scanner(System.in);
    public TA(T t){
        this.t = t;
    }
    @Override
    public void run() {
        char c;
        while(true){
            System.out.println("请输入你的指令：Q表示退出");
            c = scanner.next().toUpperCase().charAt(0);
            if(c == 'Q'){
//                System.out.println("输入字符为：" + c);
                t.setLoop(false);
                break;
            }

        }
    }
}
