package com.keen.set_;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set hashSet = new HashSet();
        /** HashSet实际上是HashMap
         * public HashSet() {
         *         map = new HashMap<>();
         *     }
         */

        //不能放入重复元素
        hashSet.add("l1");
        hashSet.add("l1");
        System.out.println("hashSet = " + hashSet);

        //如果判断是否为重复元素
        hashSet.clear();
        hashSet.add(new Dog("d1"));
        hashSet.add(new Dog("d1"));//不是重复元素
        System.out.println("hashSet = " + hashSet);

        hashSet.clear();
        hashSet.add(new String("l1"));
        hashSet.add(new String("l1"));//是重复元素
        System.out.println("hashSet = " + hashSet);


    }
}

class Dog{
    String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
