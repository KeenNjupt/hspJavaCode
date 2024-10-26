package com.keen.qqserver.service;

import com.keen.qqcommon.Message;
import com.keen.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerConnectClientThread extends Thread {
    private Socket socket;
    private String userId;

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("服务器与客户端" + userId + "保持通信，读取数据...");
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) objectInputStream.readObject();
                //待使用message
                if(MessageType.MESSAGE_GET_ONLINE_FRIEND.equals(message.getMesType())){
                    //用户在线列表信息为：aaa bbb ccc dd
                    System.out.println(message.getSender() + "正在拉取在线用户列表");
                    //创建包含在线用户列表信息的message对象
                    String onlineUser = ManageClientThread.getOnlineUser();
                    Message messageFromServer = new Message();
                    messageFromServer.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    messageFromServer.setContent(onlineUser);
                    messageFromServer.setGetter(message.getSender());
                    //发送给客户端
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeObject(messageFromServer);
//                    objectOutputStream.close(); //不能关闭stream，会导致socket也关闭
                }
                else if(MessageType.MESSAGE_COMM_MES.equals(message.getMesType())){
                    //服务器将消息转发给指定用户
                    //获取与目标用户通信的socket
                    ServerConnectClientThread clientThread = ManageClientThread.getClientThread(message.getGetter());
                    //如果用户不在线，可以将数据保存到数据库，可以实现离线留言
                    if (clientThread == null){
                        QQServer.addOfflineMessage(message.getGetter(), message);
                    }
                    else {
                        Socket clientSocket = clientThread.getSocket();
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                        objectOutputStream.writeObject(message);
                    }

                }
                else if(MessageType.MESSAGE_TO_ALL_MES.equals(message.getMesType())){
                    //服务器将消息转发给所有用户，除了发送者
                    //获取与目标用户通信的socket
                    List<String> onlineUserList = ManageClientThread.getOnlineUserList();
                    for(String uid : onlineUserList) {
                        if(uid.equals(message.getSender())){
                            continue;
                        }
                        ServerConnectClientThread clientThread = ManageClientThread.getClientThread(uid);
                        Socket clientSocket = clientThread.getSocket();
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                        objectOutputStream.writeObject(message);//如果用户不在线，可以将数据保存到数据库，可以实现离线留言
                    }

                }
                else if(MessageType.MESSAGE_CLIENT_EXIT.equals(message.getMesType())){
                    //客户端发送退出消息时,将线程移除hashMap,关闭socket，退出线程的while循环
                    String clientUser = message.getSender();
                    System.out.println( clientUser + " 退出");
                    ManageClientThread.removeClientThread(clientUser);
                    socket.close();
                    break;

                }
                else if(MessageType.MESSAGE_FILE_MES.equals(message.getMesType())){
                    //将消息对象转发给message的getter
                    String getter = message.getGetter();
                    ServerConnectClientThread clientThread = ManageClientThread.
                            getClientThread(getter);
                    Socket clientSocket = clientThread.getSocket();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                    objectOutputStream.writeObject(message);//如果用户不在线，可以将数据保存到数据库，可以实现离线留言

                }
                else if(MessageType.MESSAGE_PULL_OFFLINE_MES.equals(message.getMesType())){
                    ArrayList<Message> offlineMessage = QQServer.getOfflineMessage(message.getSender());
                    ServerConnectClientThread clientThread = ManageClientThread.
                            getClientThread(message.getSender());
                    Socket clientSocket = clientThread.getSocket();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                            clientSocket.getOutputStream());
                    if(offlineMessage != null){
                        for(Message messageItem : offlineMessage){
                            System.out.println(String.format("发送离线消息给 %s", message.getSender()));
                            objectOutputStream.writeObject(messageItem);
                        }
                    }
                }
                else{
                    //其他类型消息，后续再处理
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ServerConnectClientThread(Socket socket, String userId){
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }
}
