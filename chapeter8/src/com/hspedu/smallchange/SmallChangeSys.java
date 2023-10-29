package com.hspedu.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    private double balance = 0;
    private String listDetail = "";
    private Scanner scanner = new Scanner(System.in);
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private double money = 0;

    public void showMenu(){
        boolean loop = true;
        String key = "";
        do{
            System.out.println("============零钱通菜单============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退    出");
            System.out.print("请选择(1-4): ");
            key = scanner.next();
            switch(key){
                case "1":
                    System.out.println("零钱通明细");
                    showListDetail();
                    break;
                case "2":
                    System.out.println("收益入账");
                    income();
                    break;
                case "3":
                    System.out.println("消费");
                    consume();
                    break;
                case "4":
                    System.out.println("退出零钱通系统");
                    loop = !exit();
                    break;
                default:
                    System.out.println("请输入正确的选项:");
                    break;

            }

        }while(loop);
    }
    public void showListDetail(){
        System.out.println(listDetail);
        System.out.println();
    }
    public void income(){
        //注释掉的代码指进入收入模块时，必须输入一个正数才能退出
        //存在用户误点击的情况，因此没有收入时，应返回菜单
//        do{
//            System.out.print("请输入收入的金额,必须为正数: ");
//            money = scanner.nextDouble();
//        }while(money <= 0);

        //输入为正数进行处理，否则不处理，返回菜单
        System.out.print("请输入收入的金额,必须为正数: ");
        money = scanner.nextDouble();
        if(money <= 0){
            System.out.println("您收入的金额不为正数，现在返回菜单");
            return;
        }

        balance += money;
        System.out.println("本次收入：" + money + ", 当前余额：" + balance);
        Date date = new Date();
        listDetail += "收益入账\t" + "+" + money + "\t" + simpleDateFormat.format(date)
                + "\t" + "余额：" + balance + "\n";

    }

    public void consume(){
        String consumeNote = "";
        System.out.println("当前余额：" + balance);
        //注释掉的代码，要求用户必须输入一个正确的值，否则无法退出
        // 不符合用户逻辑
        //do{
        //    System.out.print("请输入消费的金额,必须为正数且小于余额: ");
        //    money = scanner.nextDouble();
        //}while(money <= 0 || money > balance);

        System.out.print("请输入消费的金额,必须为正数且小于等于余额: ");
        money = scanner.nextDouble();
        if(money <= 0 || money > balance){
            System.out.println("您输入的消费金额不为正数或大于余额，返回到菜单栏");
            return;
        }

        System.out.print("请输入消费备注：");
        consumeNote = scanner.next();
        balance -= money;
        System.out.println("本次消费：" + money + ", 当前余额：" + balance);
        Date date = new Date();
        listDetail += consumeNote + "\t" + "-" + money + "\t" + simpleDateFormat.format(date)
                + "\t" + "余额：" + balance + "\n";
    }
    public boolean exit(){
        boolean isExit = true;
        String choice = "";
        do{
            System.out.println("你确定要退出吗？y/n");
            choice = scanner.next();
        }while(!("y".equals(choice)) && !("n".equals(choice)));
        isExit = "y".equals(choice);
        return isExit;
    }
}
