package com.keen.sockettest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtil {
    public static void read(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int bufferLen = -1;
        while( (bufferLen = inputStream.read(buffer)) != -1){
            System.out.println(new String(buffer, 0, bufferLen));
        }
    }
    public static void write(OutputStream outputStream, byte[] data) throws IOException {
        outputStream.write(data);
    }
}
