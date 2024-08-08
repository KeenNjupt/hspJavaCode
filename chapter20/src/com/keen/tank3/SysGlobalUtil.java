package com.keen.tank3;

import java.awt.*;
import java.util.Vector;

public class SysGlobalUtil {
    public static HeroTank heroTank = null;
    public static Vector<EnemyTank> enemyTank = null;
    public static ShortBullet damonShortBullet = new ShortBullet(new Vector<Bullet>());
    public static void register(HeroTank MyHeroTank, Vector<EnemyTank> MyEnemyTank){
        heroTank = MyHeroTank;
        enemyTank = MyEnemyTank;
    }

    public static Vector<EnemyTank> getEnemyTank() {
        return enemyTank;
    }

    public static void checkBulletAndTank(){
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
    public static void checkBulletForTank(Tank tank, Vector<Bullet> bulletVector){
        if(bulletVector == null){
            return;
        }
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
    public static boolean isOverlapped(Tank tank){
        boolean res = false;
        if(heroTank.isOverlappedWithTank(tank) || tank.isOverlappedWithTank(heroTank)) {
            System.out.println("重叠了:");
            System.out.println(heroTank);
            System.out.println(tank);
            res = true;
        }
        else{
            for(Tank t : enemyTank){
                if(t.isOverlappedWithTank(tank) || tank.isOverlappedWithTank(t)){
                    System.out.println("重叠了:");
                    System.out.println(t);
                    System.out.println(tank);
                    res = true;
                    break;
                }
            }
        }
        return res;
    }
    public static void addBulletToDamonBulletVector(Vector<Bullet> v){
        damonShortBullet.bulletVector.addAll(v);
    }
    public static void drawDamonBullet(Graphics g){
        for(Bullet i : damonShortBullet.bulletVector){
            i.draw(g);
        }
    }
}
