package com.hspedu.polyarray;

import java.sql.Struct;

public class Test {
    public static void main(String[] args) {
        Person[] arr = new Person[5];
        arr[0] = new Person("mack", 10);
        arr[1] = new Student("jack", 15, 30);
        arr[2] = new Student("mary", 17, 80);
        arr[3] = new Teacher("wang", 50, 20000);
        arr[4] = new Teacher("peng", 40, 30000);

        //use instanceof to determine the runtime type
        for(int i = 0; i < arr.length; ++i){
            System.out.println(arr[i].say());
            if(arr[i] instanceof Student){
//                ((Student) arr[i]).study();//can input arr[i].study, the IDE will auto cast the type
                ((Student)arr[i]).study();
            }
            else if(arr[i] instanceof Teacher){
                ((Teacher)arr[i]).teach();
            }
//            else{
//
//            }
        }
    }

}

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String say(){
        return "name is " + getName() + ", age is " + getAge();
    }
}

class Student extends Person{
    private int score;

    public Student(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String say() {
        return "student " + super.say() + ", score is " + getScore();
    }
    public void study(){
        System.out.println("student " + getName() + " is studying");
    }
}

class Teacher extends Person{
    private double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String say() {
        return "teacher " + super.say() + "salary is " + getSalary();
    }
    public void teach(){
        System.out.println("teacher " + getName() + " is teaching");
    }
}
