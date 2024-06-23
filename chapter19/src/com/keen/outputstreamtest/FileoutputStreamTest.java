package com.keen.outputstreamtest;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileoutputStreamTest {
    public static void main(String[] args) {

    }

    @Test
    public void writeFile(){
        String filePath = "E:\\write_test2.txt";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath); //覆盖当前文件中的内容，若文件不存在会新建文件
//            fileOutputStream = new FileOutputStream(filePath,true); //追加当前文件中的内容，若文件不存在会新建文件
            String str = "line 2:keen, hello world!\n";
            fileOutputStream.write(str.getBytes());
            fileOutputStream.write(str.getBytes());//该输出流没有关闭时，就是一直向文件中追加写入
//            fileOutputStream.write(str.getBytes(),0,3);//write(byte[], off, len) byte数组[0,0+3-1]
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            try {
                if(fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
