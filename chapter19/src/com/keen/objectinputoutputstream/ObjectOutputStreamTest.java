package com.keen.objectinputoutputstream;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Vector;


public class ObjectOutputStreamTest {
    /**
     * 将对象保存到文件中，并能从文件中恢复
     * 保存对象，即保存对象的数据类型和值至文件中，这一过程被成为序列化
     * 从文件中读取数据类型和值，在程序中恢复为对象，这一过程被称为序列化
     * java中要使一个对象可以序列化和反序列化，需要保证该对象的类实现如下两个接口之一
     * 1. Serializable //该接口是个标记接口，即没有方法，推荐使用
     * 2. Externalizable
     *
     * ObjectOutputStream为处理流，可以进行对象的序列化
     */

    private static int num = 5;
    @Test
    void test() throws IOException {
        //序列化后， 保存的文件格式， 不是存文本， 而是按照特殊的格式来保存
        String filePath = "E:\\object.dat";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));

        objectOutputStream.writeInt(100);// int -> Integer (实现了 Serializable)
        objectOutputStream.writeBoolean(true);// boolean -> Boolean (实现了 Serializable)
        objectOutputStream.writeChar('a');// char -> Character (实现了 Serializable)
        objectOutputStream.writeDouble(9.5);// double -> Double (实现了 Serializable)
        objectOutputStream.writeUTF("来了，老弟");//String
        //保存一个 dog 对象
        objectOutputStream.writeObject(new Dog("旺财", 10));
        objectOutputStream.close();
    }
    @Test
    void testVector() throws IOException {
        String filePath = "E:\\vectorObject.txt";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        Vector<Dog> dogs = new Vector<>();
        dogs.add(new Dog("tom", 10));
        dogs.add(new Dog("merry", 5));
        objectOutputStream.writeInt(num);
        objectOutputStream.writeObject(dogs);
        objectOutputStream.close();
    }
}

class Dog implements Serializable {
    String name;
    int age;
    //serialVersionUID 序列化版本号，提升兼容性
    static private final long serialVersionUID = 1L;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public void test(){

    }
}
