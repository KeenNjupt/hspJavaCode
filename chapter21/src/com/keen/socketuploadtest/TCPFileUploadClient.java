package com.keen.socketuploadtest;

import com.keen.sockettest.IOUtil;
import com.keen.util.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPFileUploadClient {
    public static void main(String[] args) throws IOException {
        //连接目标服务器的8888端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //获取磁盘文件的文件流
        String filePath = "E:\\jack.jpg";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
        //将文件流内容转为字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        bufferedInputStream.close();
        //获取socket输出流
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        //通过socket输出流，将文件内容产生的字节数组发送到服务器端
        bufferedOutputStream.write(bytes);
        //发送内容结束标志
        socket.shutdownOutput();
        //接收服务器端发送的内容
        InputStream inputStream = socket.getInputStream();
//        IOUtil.read(inputStream);
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);
        bufferedOutputStream.close();
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
