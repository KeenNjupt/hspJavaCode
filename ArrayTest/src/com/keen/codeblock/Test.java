package com.keen.codeblock;

public class Test {
    public static void main(String[] args) {
        new P(1);
        new P(1,"l");
    }
}

class P{
    private int age;
    private String name;
    {
        System.out.println("this is a code block");
    }

    public P(int age) {
        System.out.println("in P(int)");
        this.age = age;
    }

    public P(int age, String name) {
        System.out.println("in P(int,String)");
        this.age = age;
        this.name = name;
    }
}
