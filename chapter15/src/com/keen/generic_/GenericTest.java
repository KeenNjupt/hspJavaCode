package com.keen.generic_;

import java.util.ArrayList;

public class GenericTest {
    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog("peter",10));
//        dogs.add(new String(("aaa"))); //编译报错
        for(Dog d : dogs){
            System.out.println(d);
        }
    }
}

class Dog{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
