package com.keen.tank3;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * 整体思路：
 * 1.声明一个子弹类Bullet，该类包含子弹对象的坐标，颜色，方向以及是否有效，声明了Bullet对象的draw方法
 * 2.对于Tank类增加一个子弹类的Vector对象bulletVector，该属性保存该Tank对象发射的有效子弹
 * 3.Tank类构造函数中启动一个线程，该线程会遍历bulletVector属性中的Bullet对象，以一定时间间隔修改其坐标
 * 并对Tank类增加一个发射字段的函数shortBullet，该函数会根据当前Tank对象的属性，
 * new一个Bullet对象添加到bulletVector中
 * 4.因此一个Tank对象中一个子线程会对该对象发射的所有有效子弹进行移动处理
 *
 * 为了显示子弹的移动轨迹
 * 1.修改Tank类的draw方法，在其draw方法中，遍历bulletVector属性中的Bullet对象，
 * 调用Bullet对象的draw方法
 * 2.将Mypanel类继承Runnable类，并重写run方法，定时调用paint方法，重绘Mypanel对象中的所有元素
 *
 * 子弹击中坦克，坦克爆炸思路
 * 1.Tank类中增加方法，判断子弹坐标是否在Tank对象中，Tank类增加属性bloomState
 * 0表示正常， 1表示爆炸，2表示爆炸结束
 * 2.在Pannel中增加方法，对我方坦克和敌方坦克判断，对方子弹是否在Tank对象内，
 * 若在则将子弹移除该子弹所属坦克的子弹vector中，
 * 3.新增展示爆炸图像的类Boom，该类中的lifeTime属性表示爆炸持续剩余时间，
 * 根据时间决定绘制哪个图像，每绘制一次 lifeTime--
 * 4.Tank类新增Boom属性
 * 并将Tank对象爆炸状态设置为1，在绘制Tank对象时检测爆炸状态，
 * 若为1则初始化Boom属性绘制爆炸图像，判断Boom属性的lifeTime为0时，将该状态设置为2
 * 为2时，则不绘制图像。当Tank对象的状态为2且bulletVector为空时，则移除该对象
 *
 * 在pannel的run方法中，在repaint前检测子弹是否击中坦克，并做相应处理
 */
public class TankV4 extends JFrame {

    MyPanel mp = null;
    public static void main(String[] args){
        TankV4 tankGameV3 = new TankV4();
    }
    public TankV4(){
        System.out.println("输入数字选择模式:\n0:开始新游戏\n1:继续上局游戏\n");
        Scanner scanner = new Scanner(System.in);
        int mode = scanner.nextInt();
        mp = new MyPanel(mode);
        new Thread(mp).start();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1300,1000);
        this.setVisible(true);
        //下面设置表示关闭图形窗口程序退出，若无该设置，则程序不会退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //增加监听关闭窗口操作，并在关闭窗口时进行相应的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                System.out.println("监听到关闭窗口");
                Record.writeNumToFile();
                System.exit(0);
            }
        });
    }
}
