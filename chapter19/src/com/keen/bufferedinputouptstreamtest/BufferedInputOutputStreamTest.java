package com.keen.bufferedinputouptstreamtest;

import org.junit.jupiter.api.Test;

import java.io.*;

public class BufferedInputOutputStreamTest {
    @Test
    void test() throws IOException {
        String filePath = "E:\\jack.jpg";
        String fileCopyPath = "E:\\jack_copy.jpg";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileCopyPath));
        byte[] buffer = new byte[1024];
        int len = -1;
        while((len = bufferedInputStream.read(buffer)) != -1 ){
            bufferedOutputStream.write(buffer, 0, len);
        }

        bufferedInputStream.close();
        bufferedOutputStream.close();

    }
}
