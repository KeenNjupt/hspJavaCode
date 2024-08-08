package com.keen.sockettest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPSocketClient {
    public static void main(String[] args) throws IOException {
        //连接目标服务器的9999端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //得到输出流
        OutputStream outputStream = socket.getOutputStream();
        //向socket中写入内容
        IOUtil.write(outputStream, "hello tcp server".getBytes());
        //表示结束写入
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        IOUtil.read(inputStream);
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
