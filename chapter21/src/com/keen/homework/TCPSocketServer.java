package com.keen.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        String response = null;
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = null;
        while(true){
            if(socket.isClosed()){
                break;
            }
            else{
                s = bufferedReader.readLine();
                if(s == null) break;
            }
            switch (s){
                case "name":
                    response = "我是keen";
                    break;
                case "hobby":
                    response = "编写java程序";
                    break;
                default:
                    response = "你说啥呢";
                    break;
            }
            bufferedWriter.write(response);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
    }
}
