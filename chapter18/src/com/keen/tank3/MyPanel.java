package com.keen.tank3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * 坦克大战绘图区域
 */
public class MyPanel extends JPanel implements KeyListener, Runnable {
    HeroTank heroTank = null;
    Vector<EnemyTank> enemyTank = new Vector<>();
    int enemySize = 3;
    MyPanel(){
        heroTank = new HeroTank(100,100, 1, 0, 5);//初始化自己的坦克
//        enemyTank = new Tank(400, 400, 1, 1); //敌方坦克
        enemyTank = new Vector<EnemyTank>();
        for( int i = 0; i < enemySize; ++i){
            EnemyTank tank = new EnemyTank(200 * (i + 1), 0, 2, 1, 2);
            new Thread(tank).start();
            tank.shortBullet();//敌方坦克发射子弹
            enemyTank.add(tank);
        }

    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,1000);
        heroTank.draw(g,this);
        for(Tank i : enemyTank){
            i.draw(g,this);
        }
//        enemyTank.draw(g);
    }

    public void checkBulletAndTank(HeroTank heroTank, Vector<EnemyTank> enemyTank){
        Vector<Bullet> heroBullet = heroTank.bulletVector;
        for(Tank i : enemyTank){
            if (heroTank.getBoomState() == 0){
                checkBulletForTank(heroTank,i.bulletVector);
            }
        }
        for(Tank i : enemyTank){
            if(i.getBoomState() == 0) {
                checkBulletForTank(i, heroBullet);
            }
        }
    }
    public void checkBulletForTank(Tank tank, Vector<Bullet> bulletVector){
        Vector<Bullet> removeBullet = new Vector<>();
        synchronized (bulletVector) {
            for (Bullet bullet : bulletVector) {
                if (tank.inTank(bullet.x, bullet.y)) {
                    tank.setBoomState(1);
                    removeBullet.add(bullet);
                }
            }
            bulletVector.removeAll(removeBullet);
        }
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
            case KeyEvent.VK_J:
                heroTank.shortBullet(); //我方坦克发射子弹
        }
//        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            checkBulletAndTank(heroTank,enemyTank);
            Vector<Tank> removeTank = new Vector<>();
            for(Tank i : enemyTank){
                if(i.getBoomState() == 2 && (i.bulletVector == null || i.bulletVector.size() == 0)){
                    removeTank.add(i);
                }
            }
            enemyTank.removeAll(removeTank);
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
//            System.out.println("repaint " + "current time is " + sdf.format(new Date()));
            this.repaint();
        }
    }
}
