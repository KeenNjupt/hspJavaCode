package com.keen.filewritertest;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) {

    }

    @Test
    void test1(){
        String filePath = "E:\\filewritertest.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);//表示覆盖
//            FileWriter fileWriter = new FileWriter(filePath, true);//表示追加
//            fileWriter.write('H');
            fileWriter.write("风雨之后，定见彩虹\n");
            fileWriter.flush(); //将流中的内容刷新到文件中,close流时也会刷新到文件中
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        try{
            if(fileWriter != null){
                fileWriter.close();
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
