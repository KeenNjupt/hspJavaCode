package com.keen.qqclient.service;

import com.keen.qqcommon.Message;
import com.keen.qqcommon.MessageType;

import java.io.*;
import java.net.Socket;

public class FileClientService {


    public void sendFileToOne(String src, String dst, String senderId, String receiverId){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setSrc(src);
        message.setDst(dst);
        message.setSender(senderId);
        message.setGetter(receiverId);

        FileInputStream fileInputStream = null;
        try {
            byte[] fileBytes = new byte[(int) new File(src).length()];
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(fileBytes);
            message.setFileBytes(fileBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        System.out.println(String.format("%s发送文件:%s至%s路径:%s", senderId, src,
                receiverId, dst));
        ClientConnectServerThread clientConnectServerThread = ManageClientConnectServerThread.
                getClientConnectServerThread(senderId);
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
