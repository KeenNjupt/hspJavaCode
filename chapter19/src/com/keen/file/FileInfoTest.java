package com.keen.file;

import org.junit.jupiter.api.Test;

import java.io.File;

public class FileInfoTest {
    public static void main(String[] args) {

    }
    @Test
    void info(){
        File file = new File("e:\\javafile.txt");
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());
        System.out.println(file.length()); //字节为单位
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());


    }
}
