package com.hspedu.inheritance;

public class Pupil extends Student{
    public Pupil() {
    }

    public Pupil(String name, int age, int score, String type) {
        super(name, age, score, type);
    }
//    public void learn(){
//        System.out.println("the pupil " + name + "is learning");
//    }
}
