package com.keen.set_;

import java.util.HashSet;
import java.util.Objects;

public class HashSetExercise02 {
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        TestPerson aa = new TestPerson(1001, "AA");
        TestPerson bb = new TestPerson(1002, "BB");
        hashSet.add(aa);
        hashSet.add(bb);
        aa.name = "CC";
        hashSet.remove(aa); //hashcode发生变化，table表的新索引位置为空，没有remove掉aa
        System.out.println(hashSet);
        hashSet.add(new TestPerson(1001,"CC"));//table表的新索引位置为空，可以加进去
        System.out.println(hashSet);
        hashSet.add(new TestPerson(1001,"AA"));//table表的新索引位置不为空，但与aa元素值相等，可以加进去
        System.out.println(hashSet);

    }
}

class TestPerson{
    int id;
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestPerson that = (TestPerson) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public TestPerson(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
