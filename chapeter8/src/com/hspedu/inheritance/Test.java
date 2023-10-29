package com.hspedu.inheritance;

public class Test {
    public static void main(String[] args) {
        Pupil jacky = new Pupil("jacky", 7, 80, "pupil");
        Graduate tom = new Graduate("tom", 22, 70, "graudate");

        jacky.showInfo();
        jacky.learn();

        tom.showInfo();
        tom.learn();

    }
}
