package com.keen.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPSocketClient {
    public static void main(String[] args) throws IOException {
        //连接目标服务器的9999端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //得到输出流
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String input = null;
        boolean isLoop = true;
        Scanner scanner = new Scanner(System.in);
        while(isLoop) {
            input = scanner.nextLine();
            //向socket中写入内容
            bufferedWriter.write(input);
            //表示结束写入,但是要求读取端要用reader进行读取
            bufferedWriter.newLine();
            //刷新流，以使内容真正写入
            bufferedWriter.flush();
            String s = bufferedReader.readLine();
            System.out.println("服务端输出：" + s);
            if("quit".equals(input)){
                isLoop = false;
            }
        }
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
    }
}
