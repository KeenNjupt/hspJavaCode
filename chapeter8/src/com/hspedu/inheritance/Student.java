package com.hspedu.inheritance;

public class Student {
    public String name;
    public int age;
    private int score;
    public String type;

    public Student() {
    }

    public Student(String name, int age, int score, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
        setScore(score);
    }
    public void showInfo(){
        System.out.println("name = " + name + " age = " + age + " score = " + getScore());
    }
    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
    public void learn(){
        System.out.println( "the "+ type + " " + name + " is learning");
    }

}
