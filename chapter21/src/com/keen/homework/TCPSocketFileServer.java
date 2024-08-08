package com.keen.homework;


import com.keen.util.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketFileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        //获取客户端传输的文件名
        String fileName = "";
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = -1;
        while((len = inputStream.read(bytes)) != -1){
            fileName += new String(bytes, 0, len);
        }
        System.out.println("客户端传输的文件名为：" + fileName);
        //获取本地文件路径
        String dstFileName = null;
        switch (fileName){
            case "高山流水":
                dstFileName = String.format("src\\%s.mp3", fileName);
                break;
            default:
                dstFileName = "src\\无名.mp3";
                break;
        }
        System.out.println("实际文件名为：" + dstFileName);
        //将本地文件内容读取到字节数组中，并发送到客户端
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(dstFileName));
        byte[] bytesData = StreamUtils.streamToByteArray(bis);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(bytesData);
        socket.shutdownOutput();
        //关闭资源
        bis.close();
        inputStream.close();
        socket.close();

    }
}
