package com.keen.chapter19exercise;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

public class ExerciseTest {
    @Test
    void testDirAndFile() throws IOException {
        String dirPath = "E:\\mytemp";
        File fileDir = new File(dirPath);
        if(!(fileDir.isDirectory())){
            fileDir.mkdirs();
        }
        String filePath = "hello.txt";
        File file = new File(fileDir, filePath);
        if(file.isFile()){
            System.out.println("文件已存在：" + file.getAbsolutePath());
        }
        else{
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("hello, world~");
            fileWriter.close();
        }
    }

    @Test
    void testBufferedReader() throws IOException {
        //utf8编码的文件可以用bufferedreader读取
        System.out.println("=============utf8=============");
        String filePath = "E:\\filereadertest.txt";
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        int i = 1;
        while((line = bufferedReader.readLine()) != null){
            System.out.println(String.format("行号%d: %s", i++, line));
        }
        bufferedReader.close();
        //gbk格式的文件需要用到转换流
        System.out.println("=============gbk=============");
        String filePath1 = "E:\\filereadertest_gbk.txt";
        FileInputStream fileInputStream = new FileInputStream(filePath1);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "gbk");
        BufferedReader bufferedReader1 = new BufferedReader(inputStreamReader);
        String line1 = null;
        int i1 = 1;
        while((line1 = bufferedReader1.readLine()) != null){
            System.out.println(String.format("行号%d: %s", i1++, line1));
        }
        bufferedReader1.close();
    }

    @Test
    void testPropertiesAndSerialization() throws IOException {
        String dogProperties = "src/dog.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(dogProperties));
        Dog dog = new Dog(properties.getProperty("name"), Integer.valueOf(properties.getProperty("age")), properties.getProperty("color"));
        System.out.println(dog);
        String dogFile = "E://dog.dat";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(dogFile));
        objectOutputStream.writeObject(dog);

    }
    @Test
    void testDeserialization() throws IOException, ClassNotFoundException {
        String dogFile = "E://dog.dat";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(dogFile));
        Object o = objectInputStream.readObject();
        System.out.println(o);

    }
}

class Dog implements Serializable{
    String name;
    int age;
    String color;


    //serialVersionUID 序列化版本号，提升兼容性
    static private final long serialVersionUID = 1L;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
