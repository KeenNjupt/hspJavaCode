package com.keen.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {

    }
    @Test
    void createFile(){
        String filePath = "e:\\javafile.txt";
        File file = new File(filePath);
        try {
            file.createNewFile(); //根据绝对路径创建
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void createFile2(){
        File parentFile = new File("e:\\");
        String filePath = "javafile2.txt";
        File file = new File(parentFile,filePath); //通过父目录File对象+路径，在父目录下创建文件
        try {
            file.createNewFile(); //根据绝对路径创建
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void createFile3(){
        String parentFilePath = new String("e:\\");
        String filePath = "javafile3.txt";
        File file = new File(parentFilePath,filePath); //通过父目录路径+路径，在父目录下创建文件
        try {
            file.createNewFile(); //根据绝对路径创建
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
