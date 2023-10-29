package com.hspedu.override_exercise;

public class Test {
    public static void main(String[] args) {
        Person mike = new Person("mike", 20);
        Student jack = new Student("jack", 22, "2222", 80);
        System.out.println(mike.say());
        System.out.println(jack.say());
    }
}
