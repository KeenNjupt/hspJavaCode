package com.keen.generic_;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericExercise {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("tom",10,new MyDate(10,1,2000)));
        employees.add(new Employee("marry",10,new MyDate(8,2,2000)));
        employees.add(new Employee("marry",10,new MyDate(9,10,2000)));
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(employees);

    }
}

class MyDate implements Comparable<MyDate>{
    private int month;
    private int day;
    private int year;

    @Override
    public String toString() {
        return "MyDate{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }

    public MyDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }


    @Override
    public int compareTo(MyDate o) {
        return month != o.month? month - o.month : day - o.day;
    }


}

class Employee implements Comparable<Employee>{
    private String name;
    private double salary;
    private MyDate birthday;

    public Employee(String name, double salary, MyDate birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }


    @Override
    public int compareTo(Employee o) {
        return name.compareTo(o.name) != 0 ? name.compareTo(o.name) : birthday.compareTo(o.birthday);
    }
}
