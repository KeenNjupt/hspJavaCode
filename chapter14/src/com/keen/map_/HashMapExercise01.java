package com.keen.map_;

import java.util.*;

public class HashMapExercise01 {
    public static void main(String[] args) {
        Map hashMap = new HashMap();
        Employee tom = new Employee("1", "tom", 2);
        Employee marry = new Employee("1", "marry", 2);
        Employee mack = new Employee("2", "mack", 3);
        hashMap.put(tom.getId(),tom);
        hashMap.put(mack.getId(),mack);
        System.out.println("first method to loop");
        Set keySet = hashMap.keySet();
        for(Object i : keySet){
            System.out.println(hashMap.get(i));
        }
        System.out.println("second method to loop");
        hashMap.put(marry.getId(),marry);
        Set set = hashMap.entrySet();
        for(Object i: set){
            Map.Entry i1 = (Map.Entry) (i);
            System.out.println(i1.getValue());
        }
        System.out.println("third method to loop");
        Collection values = hashMap.values();
        for(Object i : values){
            System.out.println(i);
        }

    }
}

class Employee{
    String id;
    String name;
    double salary;

    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getId() {
        return id;
    }
}
