package com.keen.qqclient.service;

import com.keen.qqcommon.Message;
import com.keen.qqcommon.MessageType;

import java.io.FileOutputStream;
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
                //如果读取到的信息为在线用户信息，则处理
                if(MessageType.MESSAGE_RET_ONLINE_FRIEND.equals(message.getMesType())){
                    //显示在线用户信息
                    System.out.println("显示用户列表");
                    String content = message.getContent();
                    String[] onlineUserList = content.split(" ");
                    for (String i : onlineUserList){
                        System.out.println("用户名为：" + i);
                    }
                }
                else if(MessageType.MESSAGE_COMM_MES.equals(message.getMesType())){
                    //处理接收到的普通消息
                    System.out.println(String.format("%s 对 %s 说 %s", message.getSender(), message.getGetter(), message.getContent()));
                }
                else if(MessageType.MESSAGE_TO_ALL_MES.equals(message.getMesType())){
                    //处理接收到的群发消息
                    System.out.println(String.format("收到来自 %s 的群发消息： %s", message.getSender(), message.getContent()));

                }
                else if(MessageType.MESSAGE_FILE_MES.equals(message.getMesType())){
                    //消息类型为文件，则将文件写入磁盘指定路径中，message.dst
                    FileOutputStream fileOutputStream = new FileOutputStream(message.getDst());
                    fileOutputStream.write(message.getFileBytes());
                    fileOutputStream.close();
                    System.out.println(String.format("收到来自 %s 的 文件，写入 %s", message.getSender(), message.getDst()));
                }
                else{
                    System.out.println("其他类型消息，暂时不处理");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    public Socket getSocket() {
        return socket;
    }
}
