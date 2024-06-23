package com.keen.filereadertest;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {

    }

    /**
     * 单个字符取文件
     */
    @Test
    void test1(){
        String filePath = "E:\\filereadertest.txt";
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
            int data = -1;
            while( (data = fileReader.read()) != -1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            if(fileReader != null){
                fileReader.close();
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    /**
     * 通过字符数组读取
     */
    @Test
    void test2(){
        String filePath = "E:\\filereadertest.txt";
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
            int readLen = -1;
            char[] buff = new char[8];
            while( (readLen = fileReader.read(buff)) != -1){
                System.out.print(new String(buff, 0, readLen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            if(fileReader != null){
                fileReader.close();
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
