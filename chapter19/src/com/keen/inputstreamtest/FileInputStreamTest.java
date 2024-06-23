package com.keen.inputstreamtest;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) {

    }

    /**使用FileInputStream以字节为单位读取文件
     *FileInputStream.read方法，返回一个字节，但到达文件末尾时则返回-1
     */
    @Test
    public void readFile(){
        String filePath = "D:\\hello.txt";
        FileInputStream fileInputStream = null;
        int readContent = -1;
        try {
            fileInputStream = new FileInputStream(filePath);
            while((readContent = fileInputStream.read()) != -1){
                System.out.print((char)readContent); //若文本中有汉字会乱码，一个汉字uft-8编码占三个字节
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**使用FileInputStream以字节为单位读取文件
     *FileInputStream.read(byte [])方法， 该方法将内容读到byte数组中，返回读取到的字节数，但到达文件末尾时则返回-1
     */
    @Test
    public void readFile1() {
        String filePath = "D:\\hello.txt";
        FileInputStream fileInputStream = null;
        byte[] buffer = new byte[8];
        int readLength = -1;
        try {
            fileInputStream = new FileInputStream(filePath);
            while ((readLength = fileInputStream.read(buffer)) != -1) {
                System.out.println(new String(buffer,0,readLength)); //若文本中有汉字会乱码，一个汉字uft-8编码占三个字节
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
