package com.keen.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * 坦克大战绘图区域
 */
public class MyPanel extends JPanel implements KeyListener {
    HeroTank heroTank = null;
    Vector<Tank> enemyTank = new Vector<>();
    int enemySize = 3;
    MyPanel(){
        heroTank = new HeroTank(100,100, 1, 0, 5);//初始化自己的坦克
//        enemyTank = new Tank(400, 400, 1, 1); //敌方坦克
        enemyTank = new Vector<Tank>();
        for( int i = 0; i < enemySize; ++i){
            enemyTank.add(new Tank(200*(i+1),0,2,1,2));
        }

    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,1000);
        heroTank.draw(g);
        for(Tank i : enemyTank){
            i.draw(g);
        }
//        enemyTank.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println(keyCode);
        switch (keyCode){
            case KeyEvent.VK_DOWN:
                System.out.println("向下箭头 被按下");
                heroTank.moveDown();
                break;
            case KeyEvent.VK_UP:
                System.out.println("向上箭头 被按下");
                heroTank.moveUp();
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("向左箭头 被按下");
                heroTank.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("向右箭头 被按下");
                heroTank.moveRight();
                break;
            case KeyEvent.VK_ADD:
                System.out.println("加号 被按下");
                heroTank.addStep();
                break;
            case KeyEvent.VK_SUBTRACT:
                System.out.println("减号 被按下");
                heroTank.minusStep();
                break;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
