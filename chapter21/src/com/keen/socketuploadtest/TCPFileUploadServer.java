package com.keen.socketuploadtest;

import com.keen.sockettest.IOUtil;
import com.keen.util.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileUploadServer {
    public static void main(String[] args) throws IOException {
        //在8888端口上创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(8888);
        //监听该端口，若有连接，则生成Socket对象
        Socket accept = serverSocket.accept();
        //接收客户端发送的内容
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = StreamUtils.streamToByteArray(inputStream);
        String dstFilePath = "src\\jack.jpg";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(dstFilePath));
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.close();
        //向客户端发送内容
        OutputStream outputStream = accept.getOutputStream();
//        IOUtil.write(outputStream, "客户端，你好。我是服务端，已收到文件".getBytes());
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("客户端，你好。我是服务端，已收到文件");
        bufferedWriter.flush();
        //设置写入结束标记
        accept.shutdownOutput();
        bufferedWriter.close();
        inputStream.close();
        accept.close();

    }
}
