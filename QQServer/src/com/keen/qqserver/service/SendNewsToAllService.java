package com.keen.qqserver.service;

import com.keen.qqcommon.Message;
import com.keen.qqcommon.MessageType;
import com.keen.utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.List;

public class SendNewsToAllService implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("请输入发送的新闻：[exit表示退出]");
            String news = Utility.readString(100);
            if("exit".equals(news)){
                break;
            }
            Message message = new Message();
            message.setSender("服务器");
            message.setContent(news);
            message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
            message.setSendTime(new Date().toString());
            List<String> onlineUserList = ManageClientThread.getOnlineUserList();
            System.out.println("服务器发送新闻：" + news);
            for(String user : onlineUserList){
                ServerConnectClientThread clientThread = ManageClientThread.getClientThread(user);
                Socket socket = clientThread.getSocket();
                ObjectOutputStream objectOutputStream = null;
                try {
                    objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeObject(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
