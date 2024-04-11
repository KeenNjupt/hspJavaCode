package com.keen.tank3;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Boom {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
    int x;
    int y;
    int lifeTime = 9;
    Image image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
    Image image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
    Image image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

    public Boom(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void draw(Graphics g, MyPanel myPanel){
//        System.out.println("boom lifeTime is " + lifeTime + "current time is " + sdf.format(new Date()));
//        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        for (StackTraceElement element : stackTraceElements) {
//            System.out.println(element.toString());
//        }
        if(lifeTime > 6){
            g.drawImage(image1,x,y,60,60,myPanel);
        }
        else if(lifeTime > 3){
            g.drawImage(image2,x,y,60,60,myPanel);
        }
        else{
            g.drawImage(image3,x,y,60,60,myPanel);
        }
        lifeTime--;
    }
    boolean isAlive(){
        return lifeTime > 0;
    }
}
