package com.keen.draw;

import javax.swing.*;
import java.awt.*;

//JFrame表示画框，Jpanel表示画板，Graphics表示画布或画笔

/**java的坐标体系为
 * ------------------------->x
 * |
 * |
 * |
 * y
 */
public class DrawCircle extends JFrame{
    private MyPanel mp = null;
    public static void main(String[] args) {
        DrawCircle drawCircle = new DrawCircle();
        //paint方法被调用的场景：组将第一次在屏幕中显示时
        //窗口变化：窗口最小化、窗口最大化、窗口大小变化
        //repaint()函数被调用
        System.out.println("程序退出");
    }
    public DrawCircle(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,1000);
        this.setVisible(true);
        //下面设置表示关闭图形窗口程序退出，若无该设置，则程序不会退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyPanel extends JPanel{
    @Override
    public void paint(Graphics g) {
        System.out.println("MyPanel.paint is called");
        super.paint(g);
        g.drawOval(100,100,100,200);
    }
}
