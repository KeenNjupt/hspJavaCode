package com.keen.eventTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove extends JFrame{
    MyPanel mp = null;

    public static void main(String[] args) {
        new BallMove();
    }
    public BallMove(){
        mp = new MyPanel();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(500,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }


}

class Ball{
    int x;
    int y;
    int size = 30;
    int step = 2;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void draw(Graphics g){
        g.fillOval(x,y,size,size);
    }
}

//键盘监听器KeyListener是一个键盘事件监听器接口，一个类实现了这个接口，该类可以监听键盘事件
class MyPanel extends JPanel implements KeyListener {

    Ball ball = new Ball(20,20);
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ball.draw(g);
    }

    //键盘输入事件
    @Override
    public void keyTyped(KeyEvent e) {

    }


    //键盘按键事件
    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println((char)e.getKeyCode() + " 被按下");
        int keyCode = e.getKeyCode();
        switch (keyCode){
            case KeyEvent.VK_DOWN:
                System.out.println("向下箭头 被按下");
                ball.y = ball.y + ball.step;
                break;
            case KeyEvent.VK_UP:
                System.out.println("向上箭头 被按下");
                ball.y = ball.y - ball.step;
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("向左箭头 被按下");
                ball.x = ball.x - ball.step;
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("向右箭头 被按下");
                ball.x = ball.x + ball.step;
                break;
        }
        this.repaint();

    }

    //键盘释放按键事件
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
