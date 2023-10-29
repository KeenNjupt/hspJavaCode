package com.hspedu.view_sourcecode;

public class Test {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        o1.equals(o2);

        String s1 = new String("123");
        String s2 = new String("456");
        s1.equals(s2);
        String s3 = s1;
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());

        Integer i = new Integer(10);

        Person p1 = new Person("jack", 10, 'm');
        Person p2 = new Person("jack", 10, 'm');
        Person p3 = new Person("mary", 10, 'm');
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
        System.out.println(p1 == p2);

    }
}

class Person{
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        setName(name);
        setAge(age);
        setAge(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj instanceof Person){
            Person p = (Person)obj;
            return  getName().equals(p.getName()) && getAge() == p.getAge()
                    &&  getGender() == p.getGender();
        }
        return false;
    }
}
