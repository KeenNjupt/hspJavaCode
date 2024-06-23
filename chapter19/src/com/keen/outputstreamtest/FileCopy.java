package com.keen.outputstreamtest;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {

    }

    @Test
    public void testFileCopy(){
        //一边读取，一边写入，每次读取一定大小的内容
        String srcFilePath = "E:\\jack.jpg";
        String destFilePath = "E:\\jack_copy.jpg";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath);
            byte[] buff = new byte[1024];
            int readLen = -1;
            while((readLen = fileInputStream.read(buff)) != -1){
                fileOutputStream.write(buff,0,readLen);
            }
        }catch (IOException e){
            throw new RuntimeException(e);

        }finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
    }
}
