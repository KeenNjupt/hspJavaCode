package com.keen.sockettest;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPSocketClientWithReaderWriter {
    public static void main(String[] args) throws IOException {
        //连接目标服务器的9999端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //得到输出流
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        //向socket中写入内容
        bufferedWriter.write("hello tcp server. I am Client 字符流");
        //表示结束写入,但是要求读取端要用reader进行读取
        bufferedWriter.newLine();
        //刷新流，以使内容真正写入
        bufferedWriter.flush();
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println("client 得到的回复：" + s);
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
    }
}
