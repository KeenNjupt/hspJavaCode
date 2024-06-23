package com.keen.bufferedreadertest;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {
//    public static void main(String[] args) {
//
//    }

    /**
     * bufferedReader为包装流/处理流，用Reader的子类进行初始化
     */
    @Test
    void testBufferedReader() throws IOException {
        String filePath = "E:\\filereadertest.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line = null;
        while((line = bufferedReader.readLine()) != null){ //按行读取
            System.out.println(line);
        }
        //关闭包装流时，包装流会去关闭内部的节点流
        bufferedReader.close();
    }
}
