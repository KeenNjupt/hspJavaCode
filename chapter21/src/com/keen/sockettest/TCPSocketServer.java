package com.keen.sockettest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketServer {
    public static void main(String[] args) throws IOException {
        //创建一个serverSocket在9999端口上
        ServerSocket serverSocket = new ServerSocket(9999);
        //监听该serverSocket,程序会阻塞直到有连接到该端口
        Socket accept = serverSocket.accept();
        //获取输入流
        InputStream inputStream = accept.getInputStream();
        //读取输入流中的内容, 无输入内容则阻塞，有输入内容则读取到，
        // 但仍会阻塞，直到对端socket设置结束写入标记
        IOUtil.read(inputStream);
        OutputStream outputStream = accept.getOutputStream();
        IOUtil.write(outputStream, "hello, client".getBytes());
        //设置结束写入标记
        accept.shutdownOutput();
        outputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
