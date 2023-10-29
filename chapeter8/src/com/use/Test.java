package com.use;

import com.tom.Dog;

public class Test {
    public static void main(String[] args) {
        //the package is a directory
        Dog dog = new Dog(); //the Dog class is the com.tom.Dog imported
        System.out.println(dog);

        com.jerry.Dog dog1 = new com.jerry.Dog();// explicitly indicate the com.jerry.Dog
        System.out.println(dog1);
    }
}
