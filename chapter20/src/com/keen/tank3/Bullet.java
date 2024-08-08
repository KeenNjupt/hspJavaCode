package com.keen.tank3;

import java.awt.*;

public class Bullet {
    int x;
    int y;
    int direction;
    boolean isAlive;
    Color color;
    int speed;
    public Bullet(int x, int y, int direction, boolean isAlive, Color color, int speed) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.isAlive = isAlive;
        this.color = color;
        this.speed = speed;
    }

    public void draw(Graphics g){
        Color oldColor = g.getColor();
        g.setColor(color);
        if(isAlive) {
            g.fill3DRect(x, y, 2, 2, false);
        }
        g.setColor(oldColor);
    }



    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public Color getColor() {
        return color;
    }

    public void checkLive(){
        if( x < 0 || x > 1000 || y < 0 || y > 1000){
            isAlive = false;
        }
    }
}
