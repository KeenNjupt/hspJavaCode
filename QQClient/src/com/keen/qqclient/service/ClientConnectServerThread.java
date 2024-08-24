package com.keen.qqclient.service;

import com.keen.qqcommon.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientConnectServerThread extends Thread{
    //该线程类持有Socket对象进行通信
    private Socket socket;
    public ClientConnectServerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){
        //使用while循环，保持客户端与服务器的通信
        while(true){

            try {
                System.out.println("客户端线程，等待从服务器发送的消息");
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                //如果服务器没有发送消息至该socket，则该线程会阻塞到这里
                Message message = (Message)objectInputStream.readObject();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    public Socket getSocket() {
        return socket;
    }
}
