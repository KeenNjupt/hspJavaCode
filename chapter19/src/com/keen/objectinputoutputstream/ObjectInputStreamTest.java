package com.keen.objectinputoutputstream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamTest {
    /**
     * ObjectOutputStream为处理流，可以进行对象的序列化
     */
    @Test
    void test() throws IOException, ClassNotFoundException {
        //反序列化各对象的顺序要和序列化时一致
        String filePath = "E:\\object.dat";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
        // 2.读取， 注意顺序
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readBoolean());
        System.out.println(objectInputStream.readChar());
        System.out.println(objectInputStream.readDouble());
        System.out.println(objectInputStream.readUTF());
        //1.反序列化对象时，要保证数据文件中记录的对象类型在当前程序中可以使用，即可引用或在同一包下
        // 2.同时如果对象类的定义发生变化时，如方法，要重新序列化一遍, 因为每次修改类时该类的序列化serialVersionUID会变化
        //要想修改类时，兼容之前版本生成的序列化文件，可以自定义serialVersionUID对象
        //如static private final long serialVersionUID = 1L;
        //3.序列化对象时，要求内部的对象也实现了序列化，static 和 transient修饰的对象不会被序列化
        //4. 序列化具有可继承性，即父类实现了序列化，则子类也自动实现了序列化
        Object o = objectInputStream.readObject();
        System.out.println(o.getClass());
        System.out.println(o);
        Dog dog = (Dog)o;
        System.out.println(dog.getAge());
        System.out.println(dog.getName());
        System.out.println(dog.getName());
        // 3.关闭
        objectInputStream.close();

    }
}
