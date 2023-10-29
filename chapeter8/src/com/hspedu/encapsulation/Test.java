package com.hspedu.encapsulation;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(150);
        person.setName("tomato yellow");
        person.setSalary(10000);
        System.out.println("age = " + person.getInfo());

        Person person1 = new Person("smith", 150, 12);
        System.out.println(person1.getInfo());

    }

}

class Person{
    public Person(){

    }
    // use set method in constructor maintain the encapsulation
    public Person(String name, int age, double salary){
        setAge(age);
        setName(name);
        setSalary(salary);
    }
    public String name;
    //age and salary is private
    private int age;
    private double salary;

    //use alt + insert to create getter and setter method
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() >= 2 && name.length() <= 6) this.name = name;
        else{
            System.out.println("the lenght of name should be [2,6], name is default value \"jack\"");
            this.name = "jack";
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age >= 1 && age <= 120) this.age = age;
        else{
            System.out.println("the age should be in [1, 120], age is default value 18");
            this.age = 18;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getInfo(){
        return "name = " + getName() + " age = " + getAge() + " salary = " + getSalary();
    }
}
