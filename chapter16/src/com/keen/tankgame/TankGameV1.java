package com.keen.tankgame;

import javax.swing.*;

public class TankGameV1 extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args){
        TankGameV1 tankGameV1 = new TankGameV1();
    }
    public TankGameV1(){
        mp = new MyPanel();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1000,1000);
        this.setVisible(true);
        //下面设置表示关闭图形窗口程序退出，若无该设置，则程序不会退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
