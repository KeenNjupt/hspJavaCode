package com.keen.draw;

import javax.swing.*;
import java.awt.*;

public class GraphicsTest extends JFrame {
    private TestPanel mp = null;
    public static void main(String[] args) {
        new GraphicsTest();
    }
    public  GraphicsTest(){
        mp = new TestPanel();
        this.add(mp);
        this.setSize(1000,1000);
        this.setVisible(true);
        //下面设置表示关闭图形窗口程序退出，若无该设置，则程序不会退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class TestPanel extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //设置画笔颜色
//        g.setColor(Color.RED);
//        g.drawLine(10,10,200,200);
//        g.drawRect(10,10,190,190);
//
//        g.setColor(Color.GRAY);
        //填充矩形
//        (x,y)为矩形的左上角,(w,h)为宽和高,宽指x轴水平方向
//        g.fillRect(10,10,190,190);
        //填充椭圆
//        g.fillOval(200,200,100,70);
        //画图片，图片放在out目录下的chapter16目录下
//        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/jack.jpg"));
//        g.drawImage(image,10,10,500,333,this);
        //写字
        g.setFont(new Font("宋体",Font.BOLD,60));
        g.drawString("你好，世界", 100, 100 ); //(100,100)表示字体的左下角坐标
    }
}


