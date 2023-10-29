package com.hspedu.override_exercise;

public class Student extends Person{
    private String id;
    private int score;

    public Student() {
    }

    public Student(String name, int age, String id, int score) {
        super(name, age);
        setId(id);
        setScore(score);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String say(){
        return super.say() + ", my id is " + getId() + ", my score is " + getScore();
    }
}
