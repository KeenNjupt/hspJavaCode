package com.keen.threaduse;

public class ThreadExit {
    public static void main(String[] args) {
        System.out.println("in main");
        TT tt = new TT();
        tt.start();
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("休眠结束");
        tt.setLoop(false); //通过子线程run方法中使用的对象控制子线程退出
    }
}

class TT extends Thread{
    private boolean loop = true;
    private int count = 0;
    @Override
    public void run() {
        while (loop){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(String.format("in %s, count is %d", Thread.currentThread().getName(), ++count));
        }
    }
    public void setLoop(boolean loop){
        this.loop = loop;
    }
}
