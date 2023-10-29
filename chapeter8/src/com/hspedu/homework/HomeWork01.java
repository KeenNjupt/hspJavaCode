package com.hspedu.homework;

import java.util.Arrays;
import java.util.Comparator;

public class HomeWork01 {
    public static void main(String[] args) {
        Person[] arr = new Person[3];
        arr[0] = new Person("jack",10,"n");
        arr[1] = new Person("mary",8,"n");
        arr[2] = new Person("tom",30,"n");
        Util util = new Util();
//        util.bubbleSort(arr);
        //使用库函数
        Arrays.sort(arr);
        for(Person t : arr){
            System.out.println(t);
        }
    }
}

class Util{
    public void bubbleSort(Person[] arr){
        int len = arr.length;
        //arr[0..i]表示待排序的数组
        for(int i = len-1; i > 0; --i){
            for(int j = 0; j < i; ++j){
                if(arr[j+1].less(arr[j])) swap(arr,j,j+1);
            }
        }
    }
    void swap(Object[] arr, int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    boolean less(Person t){
        return age < t.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return age - o.age;
    }
}
