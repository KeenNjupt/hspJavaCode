package com.keen.sockettest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketServerWithReaderWriter {
    public static void main(String[] args) throws IOException {
        //创建一个serverSocket在9999端口上
        ServerSocket serverSocket = new ServerSocket(9999);
        //监听该serverSocket,程序会阻塞直到有连接到该端口
        Socket accept = serverSocket.accept();
        //获取输入流
        InputStream inputStream = accept.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println("server 得到的信息：" + s);
        OutputStream outputStream = accept.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        //向socket中写入内容
        bufferedWriter.write("hello tcp client. I am server 字符流");
        //表示结束写入,但是要求读取端要用reader进行读取
        bufferedWriter.newLine();
        //刷新流，以使内容真正写入
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
        accept.close();
        serverSocket.close();
    }
}
