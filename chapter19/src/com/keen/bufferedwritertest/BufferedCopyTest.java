package com.keen.bufferedwritertest;

import org.junit.jupiter.api.Test;

import java.io.*;

public class BufferedCopyTest {
    @Test
    void testBufferedReaderAndWriter(){

        //BufferedReader和BufferedWriter可以操作文本文件，不要用来操作二进制文件，容易造成二进制文件损害

        String filePath = "E:\\filereadertest.txt";
        String fileCopyPath = "E:\\bufferedCopy.txt";
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            bufferedWriter = new BufferedWriter(new FileWriter(fileCopyPath));
            String line = null;
            while((line = bufferedReader.readLine()) != null){ //readLine读取一行，但内容中没有换行符
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(bufferedReader != null){
                    bufferedReader.close();
                }
                if(bufferedWriter != null){
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
