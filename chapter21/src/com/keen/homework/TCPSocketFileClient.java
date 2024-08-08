package com.keen.homework;

import com.keen.util.StreamUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPSocketFileClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
//        String fileName = "高山流水";
        String fileName = "高山";
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(fileName.getBytes());
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = StreamUtils.streamToByteArray(inputStream);
        String filePath = String.format("E:\\%s.mp3", fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        fileOutputStream.write(bytes);

        fileOutputStream.close();
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
