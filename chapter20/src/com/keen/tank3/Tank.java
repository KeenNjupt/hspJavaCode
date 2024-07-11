package com.keen.tank3;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

public class Tank {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
    protected int x;
    protected int y;
    //坦克方向:上下左右
    protected int direction;
    //坦克类型,友方,敌方
    protected int type;
    protected  int step;
    protected boolean modifyStep = false;
    Vector<Bullet> bulletVector = new Vector<Bullet>();
    int bulletThreshold = 5;
    int boomState = 0; //0表示正常，1表示爆炸中，2表示爆炸完成
    Boom boom = null;
    Boolean isAlive = true;
    ShortBullet shortBullet = null;
    int bottom = 0;
    int height = 1000-60;
    int leftLimit = 0 + 10;
    int rightLimit = 1000 - 60 + 10;
    int rightBound = 0;
    int downBound = 0;
    int leftBound = 0;
    int upBound = 0;


    public Tank(int x, int y, int direction, int type, int step) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.type = type;
        this.step = step;
        shortBullet = new ShortBullet(bulletVector);
        new Thread(shortBullet).start();
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

    public int getBoomState() {
        return boomState;
    }

    public void setBoomState(int boomState) {
        this.boomState = boomState;
    }
    public int getLeftBound(){
        if(direction == 1 || direction == 2){
            leftBound = x ;
        }
        else{
            leftBound = x - 10;
        }
        return leftBound;
    }
    public int getUpBound(){
        if(direction == 1 || direction == 2){
            upBound = y ;
        }
        else{
            upBound = y + 10;
        }
        return leftBound;
    }

    public int getRightBound() {
        if(direction == 1 || direction == 2){
            rightBound = x + 40;
        }
        else{
            rightBound = x - 10 + 60;
        }
        return rightBound;
    }

    public int getDownBound() {
        if(direction == 1 || direction == 2){
            downBound = y + 60;
        }
        else{
            downBound = y + 10 + 40;
        }
        return downBound;
    }
    public boolean isOverlappedWithTank(Tank tank){
        boolean res = false;
        if(tank == this) return false;
        int tankDownBound = tank.getDownBound();
        int tankRightBound = tank.getRightBound();
        int tankLeftBound = tank.getLeftBound();
        int tankUpBound = tank.getUpBound();
        if(inTankWithRec(tankLeftBound, tankUpBound) || inTankWithRec(tankLeftBound, tankDownBound)
        || inTankWithRec(tankRightBound, tankUpBound) || inTankWithRec(tankRightBound, tankDownBound)){
            res = true;
        }
        return res;
    }
    boolean inTankWithRec(int x, int y){
        boolean res = false;
        int downBound1 = getDownBound();
        int rightBound1 = getRightBound();
        if(x >= this.x && x <= rightBound1 && y >= this.y && y <= downBound1){
            res = true;
        }
        return res;

    }


    public void changeDirection(int i){
        if(i < 1 || i > 4){
            return;
        }
        int oldDirection = direction;
        direction = i;
        if(SysGlobalUtil.isOverlapped(this)){
            direction = oldDirection;
        }

    }
    public void moveUp(){
        int oldDirection = direction;
        int oldY = y;
        this.direction = 1;
        if(this.y - step >= bottom) this.y -= step;
        if(SysGlobalUtil.isOverlapped(this)){
            direction = oldDirection;
            y = oldY;
        }
        System.out.println(this);
    }
    public void moveDown(){
        int oldDirection = direction;
        int oldY = y;
        this.direction = 2;
        if(this.y + step <= height) this.y += step;
        if(SysGlobalUtil.isOverlapped(this)){
            direction = oldDirection;
            y = oldY;
        }
    }
    public void moveLeft(){
        int oldDirection = direction;
        int oldX = x;
        this.direction = 4;
        if(this.x - step >= leftLimit) this.x -= step;
        if(SysGlobalUtil.isOverlapped(this)){
            direction = oldDirection;
            x = oldX;
        }
    }
    public void moveRight(){
        int oldDirection = direction;
        int oldX = x;
        this.direction = 3;
        if(this.x + step <= rightLimit) this.x += step;
        if(SysGlobalUtil.isOverlapped(this)){
            direction = oldDirection;
            x = oldX;
        }
    }
    public void addStep(){
        this.step++;
        modifyStep = true;
    }
    public void minusStep(){
        this.step--;
        modifyStep = true;
    }
    public void  shortBullet(){
        synchronized (bulletVector){
            if(bulletVector.size() == bulletThreshold){
                return;
            }
        }
        int bulletX = 0, bulletY = 0;
        switch (direction){
            //向上
            case 1:
                bulletX = x + 20;
                bulletY = y;
                break;
            //向下
            case 2:
                bulletX = x + 20;
                bulletY = y + 60;
                break;
            //向右
            case 3:
                bulletX = x + 60 - 10;
                bulletY = y + 20 + 10;
                break;
            //向左
            case 4:
                bulletX = x - 10;
                bulletY = y + 20 + 10;
                break;
        }

        Bullet bullet = new Bullet(bulletX, bulletY, direction, true, type == 0 ? Color.CYAN : Color.yellow, 4);
        bulletVector.add(bullet);
    }
    boolean inTank(int x, int y) {
        boolean res = false;
        switch (direction) {
            //向上
            case 1:
                if (x >= this.x && x <= this.x + 10 && y >= this.y && y <= this.y + 60) {//左轮子
                    res = true;
                    break;
                }
                if (x >= this.x + 10 && x <= this.x + 30 && y >= this.y + 10 && y <= this.y + 50) {//底座
                    res = true;
                    break;
                }
                if (x >= this.x + 30 && x <= this.x + 40 && y >= this.y && y <= this.y + 60) {//右轮子
                    res = true;
                    break;
                }
                if (x == this.x + 20 && y >= this.y && y <= this.y + 20) {//炮筒
                    res = true;
                    break;
                }
                break;
            //向下
            case 2:
                if (x >= this.x && x <= this.x + 10 && y >= this.y && y <= this.y + 60) {//左轮子
                    res = true;
                    break;
                }
                if (x >= this.x + 10 && x <= this.x + 30 && y >= this.y + 10 && y <= this.y + 50) {//底座
                    res = true;
                    break;
                }
                if (x >= this.x + 30 && x <= this.x + 40 && y >= this.y && y <= this.y + 60) {//右轮子
                    res = true;
                    break;
                }
                if (x == this.x + 20 && y >= this.y + 40 && y <= this.y + 60) {//炮筒
                    res = true;
                    break;
                }
                break;
            //向右
            case 3:
                if (x >= this.x - 10 && x <= this.x + 50 && y >= this.y + 10 && y <= this.y + 20) {//上轮子
                    res = true;
                    break;
                }
                if (x >= this.x && x <= this.x + 40 && y >= this.y + 20 && y <= this.y + 40) {//底座
                    res = true;
                    break;
                }
                if (x >= this.x - 10 && x <= this.x + 50 && y >= this.y + 40 && y <= this.y + 50) {//下轮子
                    res = true;
                    break;
                }
                if (x >= this.x + 30 && x <= this.x + 50 && y == this.y + 30) {//炮筒
                    res = true;
                    break;
                }
                break;
            //向左
            case 4:
                if (x >= this.x - 10 && x <= this.x + 50 && y >= this.y + 10 && y <= this.y + 20) {//上轮子
                    res = true;
                    break;
                }
                if (x >= this.x && x <= this.x + 40 && y >= this.y + 20 && y <= this.y + 40) {//底座
                    res = true;
                    break;
                }
                if (x >= this.x - 10 && x <= this.x + 50 && y >= this.y + 40 && y <= this.y + 50) {//下轮子
                    res = true;
                    break;
                }
                if (x >= this.x - 10 && x <= this.x + 10 && y == this.y + 30) {//炮筒
                    res = true;
                    break;
                }
                break;
        }
        return res;
    }
    public void draw(Graphics g, MyPanel myPanel){
        if(!isAlive) return;
        for(Bullet i : bulletVector){
            i.draw(g);
        }
//        System.out.println( "current time is " + sdf.format(new Date()));
//        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        for (StackTraceElement element : stackTraceElements) {
//            System.out.println(element.toString());
//        }
        switch (type){
            case 0:
                g.setColor(Color.CYAN);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }

        if(boomState == 1){
            if(boom == null){
                boom = new Boom(x,y);
            }
            if(boom.isAlive()){
                boom.draw(g,myPanel);
            }
            else{
                boomState = 2;
                isAlive = false;
                //当tank状态设置为false时，将其子弹交给后端字段进程进行展示，自身子弹清空
                SysGlobalUtil.addBulletToDamonBulletVector(bulletVector);
                bulletVector = null;
            }
            return;
        }

//        if(this instanceof  HeroTank) System.out.println("HeroTank x = " + x + ", y = " + y);
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

    @Override
    public String toString() {
        return "Tank{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }
}

class ShortBullet implements Runnable{
    Vector<Bullet> bulletVector;
    boolean isAlive = true;

    public ShortBullet(Vector<Bullet> bulletVector) {
        this.bulletVector = bulletVector;
    }

    @Override
    public void run() {
        while(isAlive) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ArrayList<Bullet> bulletArrayList = new ArrayList<>();
            synchronized (bulletVector) {
                for (Bullet bullet : bulletVector) {
                    switch (bullet.getDirection()) {
                        //向上
                        case 1:
                            bullet.y -= bullet.speed;
                            break;
                        //向下
                        case 2:
                            bullet.y += bullet.speed;
                            break;
                        //向右
                        case 3:
                            bullet.x += bullet.speed;
                            break;
                        //向左
                        case 4:
                            bullet.x -= bullet.speed;
                            break;
                    }
                    bullet.checkLive();
                    if (!bullet.isAlive()) {
                        bulletArrayList.add(bullet);
                    }
                    System.out.println(String.format("x = %d, y = %d", bullet.x, bullet.y));
                }
                for (Bullet bullet : bulletArrayList) {
                    bulletVector.remove(bullet);
                }
            }
        }
    }
}
