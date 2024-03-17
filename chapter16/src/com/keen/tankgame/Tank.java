package com.keen.tankgame;

import java.awt.*;

public class Tank {
    protected int x;
    protected int y;
    //坦克方向:上下左右
    protected int direction;
    //坦克类型,友方,敌方
    protected int type;
    protected  int step;
    protected boolean modifyStep = false;

    public Tank(int x, int y, int direction, int type, int step) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.type = type;
        this.step = step;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveUp(){
        this.direction = 1;
        this.y -= step;
    }
    public void moveDown(){
        this.direction = 2;
        this.y += step;
    }
    public void moveLeft(){
        this.direction = 4;
        this.x -= step;
    }
    public void moveRight(){
        this.direction = 3;
        this.x += step;
    }
    public void addStep(){
        this.step++;
        modifyStep = true;
    }
    public void minusStep(){
        this.step--;
        modifyStep = true;
    }
    public void draw(Graphics g){
        switch (type){
            case 0:
                g.setColor(Color.CYAN);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }
        switch (direction) {
            //向上
            case 1:
                g.fill3DRect(x, y, 10, 60, false); //左轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//底座
                g.fill3DRect(x + 30, y, 10, 60, false);//右轮子
                g.fillOval(x + 10, y + 20, 20, 20);//圆盖
                g.drawLine(x + 20, y, x + 20, y + 20);//炮筒
                break;
            //向下
            case 2:
                g.fill3DRect(x, y, 10, 60, false); //左轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//底座
                g.fill3DRect(x + 30, y, 10, 60, false);//右轮子
                g.fillOval(x + 10, y + 20, 20, 20);//圆盖
                g.drawLine(x + 20, y + 40 , x + 20, y + 60);//炮筒
                break;
            //向右
            case 3:
                g.fill3DRect(x - 10, y + 10, 60, 10, false); //上轮子
                g.fill3DRect(x + 10 - 10, y + 10 + 10, 40, 20, false);//底座
                g.fill3DRect(x - 10, y + 30 + 10, 60, 10, false);//下轮子
                g.fillOval(x + 20 - 10, y + 10 + 10, 20, 20);//圆盖
                g.drawLine(x + 40 - 10, y + 20 + 10, x + 60 - 10, y + 20 + 10);//炮筒
                break;
            //向左
            case 4:
                g.fill3DRect(x - 10, y + 10, 60, 10, false); //上轮子
                g.fill3DRect(x + 10 - 10, y + 10 + 10, 40, 20, false);//底座
                g.fill3DRect(x - 10, y + 30 + 10, 60, 10, false);//下轮子
                g.fillOval(x + 20 - 10, y + 10 + 10, 20, 20);//圆盖
                g.drawLine(x - 10, y + 20 + 10, x + 20 - 10, y + 20 + 10);//炮筒
                break;

        }
        if(modifyStep){
            g.drawString("当前速度为 " + step, 10, 10);
            modifyStep = false;
        }

    }
}
