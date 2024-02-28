package com.keen.set_;

import java.util.HashSet;
import java.util.Objects;

public class HashSetExercise {
    public static void main(String[] args) {
        //让名字和年龄相同的元素不重复添加进HashSet中
        HashSet hashSet = new HashSet();
        hashSet.add(new Person("smith","11"));
        hashSet.add(new Person("tom","12"));
        hashSet.add(new Person("tom","12"));
        //HashSet判断元素是否相同，元素的hash值和元素equals方法都相同
        //hash值决定元素放在数组中哪个位置，equals判断已有元素是否相同
        System.out.println(hashSet);
    }
}

class Person{
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    //IDEA生成的equals和hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    /**自定义hashCode和equals
    @Override
    public int hashCode() {
        return name.hashCode() & age.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        else{
            if(obj instanceof Person){
                Person p = (Person)(obj);
                return p.age.equals(age) && p.name.equals(name);
            }
            else return false;
        }
    }
    */

    public void setAge(String age) {
        this.age = age;
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
