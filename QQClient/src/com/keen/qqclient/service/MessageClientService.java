package com.keen.qqclient.service;

import com.keen.qqcommon.Message;
import com.keen.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

/**
 * 提供消息相关的服务
 */
public class MessageClientService {
    //发送消息给指定单个用户，先将消息发送给服务器，再由服务器转发给指定用户
    public void sendMessageToOne(String content, String senderId, String receiverId){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setSender(senderId);
        message.setGetter(receiverId);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        System.out.println(String.format("%s 对 %s 说 %s", senderId, receiverId, content));

        ClientConnectServerThread clientConnectServerThread = ManageClientConnectServerThread.getClientConnectServerThread(senderId);
        Socket socket = clientConnectServerThread.getSocket();
        try {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //发送消息给所有用户，先将消息发送给服务器，再由服务器转发给所有用户(除发送者)
    public void sendMessageToAll(String content, String senderId){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
        message.setSender(senderId);
        message.setContent(content);
        message.setSendTime(new Date().toString());
        System.out.println(String.format("%s 群发消息 说 %s", senderId, content));

        ClientConnectServerThread clientConnectServerThread = ManageClientConnectServerThread.getClientConnectServerThread(senderId);
        Socket socket = clientConnectServerThread.getSocket();
        try {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void pullOfflineMessage(String userId){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_PULL_OFFLINE_MES);
        message.setSender(userId);
        System.out.println(String.format("%s 拉取离线信息", userId));

        ClientConnectServerThread clientConnectServerThread = ManageClientConnectServerThread.
                getClientConnectServerThread(userId);
        Socket socket = clientConnectServerThread.getSocket();
        try {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
