package com.keen.threaduse;

public class DaemonThreadTest {
    public static void main(String[] args) {
//        Thread.State
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true);//将其设置为守护线程，当非守护线程都结束时，则所有的守护线程结束
        daemonThread.start();

        for(int i = 0; i < 10; ++i) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("in MainThread....");
        }
    }
}

class DaemonThread extends Thread{
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("in DaemonThread....");
        }
    }
}
