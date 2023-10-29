package com.keen.innerclasstest;

public class AnonymousInnerClassExercise {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        //对于一次性使用的类对象，采用匿名内部类形式
        //不用再声明一个类
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });

        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴们上课了");
            }
        });
    }
}

interface Bell{
    void ring();
}

class CellPhone{
    public void alarmClock(Bell bell){
        bell.ring();
    }
}
