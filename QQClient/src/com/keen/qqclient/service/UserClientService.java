package com.keen.qqclient.service;

import com.keen.qqcommon.Message;
import com.keen.qqcommon.MessageType;
import com.keen.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class UserClientService {

    private User user = new User();
    private Socket socket;
    public boolean checkUser(String userId, String pwd){
        boolean res = false;
        user.setUserId(userId);
        user.setPassword(pwd);
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            //获取向socket输入内容的对象流,发送User对象
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(user);

            //读取来自服务器的Message对象
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Message message = (Message)objectInputStream.readObject();
            if(message.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){ //登录成功
                //创建一个和服务器保持通信的线程，该线程持有socket -> ClientConnectServerThread
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                clientConnectServerThread.start();
                //将启动的线程放入Map中管理，userId -> 线程对象
                ManageClientConnectServerThread.addClientConnectServerThread(userId, clientConnectServerThread);
                res = true;
            }
            else{ //登录失败时，关闭socket
                socket.close();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }
}
