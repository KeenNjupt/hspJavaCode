package com.hspedu.inheritance_theory;

public class Test {
    public static void main(String[] args) {
        Son son = new Son();
        //for son.name, find the name from Son -> Father -> Grandpa -> Object
        //if in one class the name variable exist , then find process stops:
        // if and name variable can be visited, visit name in the class
        //else return error
        //firstly match the "name" of variable
        System.out.println(son.name);
        System.out.println(son.age); // age in Father class
        System.out.println(son.hobby); // hobby in Grandpa
//        System.out.println(son.height); // error: find the Son.height, but the Son.height is private

    }
}

class Grandpa{
    String name = "grandpa";
    String hobby = "fishing";
}

class Father extends Grandpa{
    String name = "father";
    int age = 40;
}

class Son extends Father{
    String name = "son";
    private int height = 10;
}

