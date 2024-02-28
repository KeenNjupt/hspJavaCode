package com.keen.set_;

import java.util.LinkedHashSet;
import java.util.Objects;

public class LinkedHashSetExercise {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Car("1",2));
        linkedHashSet.add(new Car("1",2));
        linkedHashSet.add(new Car("1",3));
//        new Car("1",3).hashCode();
        System.out.println(linkedHashSet);


    }
}

class Car{
    //要求LinkedHashSet添加Car对象时，name和price一样时表示相同元素，不重复添加
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
    @Override
    public int hashCode(){
        return Objects.hash(name,price);
    }

    public boolean equals(Object o){
        if(this == o) return true;
        else{
            if(o instanceof Car){
                Car oc = (Car)(o);
                return name.equals(oc.name) && price == oc.price;
            }
            else return false;
        }
    }
}
