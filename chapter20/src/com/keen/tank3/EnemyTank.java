package com.keen.tank3;

public class EnemyTank extends Tank implements Runnable{
    int count = 30;
    public EnemyTank(int x, int y, int direction, int type, int step) {
        super(x, y, direction, type, step);
        this.bulletThreshold = 1;
    }

    private void randomMove(){ //随机移动
        for(int i = 0; i < count; ++i){ //惯性，向一个方向运动一定次数
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (direction){
                case 1: //上
                    moveUp();
                    break;
                case 2://下
                    moveDown();
                    break;
                case 3://右
                    moveRight();
                    break;
                case 4://左
                    moveLeft();
                    break;
            }
        }
        int randomDirection = (int)(Math.random()*4) + 1; //随机设置方向
        changeDirection(randomDirection);
    }

    @Override
    public void run() {
        while(isAlive){
            randomMove();
            if(bulletVector != null && bulletVector.size() < bulletThreshold){ //发射子弹
                this.shortBullet();
            }
        }
    }
}
