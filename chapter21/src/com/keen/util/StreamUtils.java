package com.keen.util;

import java.io.*;

public class StreamUtils {
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        //创造字节输出流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len;
        //循环读取输入流中的内容至字节数组中，并将字节数组内容输出至字节输出流中
        while ((len = is.read(bytes)) != -1){
            byteArrayOutputStream.write(bytes, 0, len);
        }
        //将字节输出流中内容输出至字节数组中
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return byteArray;
    }
    public static String streamToString(InputStream is) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line + "\r\n");
        }
        return stringBuilder.toString();
    }
}
