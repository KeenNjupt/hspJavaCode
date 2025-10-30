package com.keen.qqserver.service;

import com.keen.qqcommon.Message;
import com.keen.qqcommon.MessageType;
import com.keen.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class QQServer {
    private ServerSocket serverSocket;
    private static ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, ArrayList<Message>> offlineMessage = new ConcurrentHashMap<>();
    static {//静态代码块会在类加载时，执行该代码块
        validUsers.put("100", new User("100", "123456"));
        validUsers.put("200", new User("200", "123456"));
        validUsers.put("300", new User("300", "123456"));
        validUsers.put("至尊宝", new User("至尊宝", "123456"));
        validUsers.put("紫霞仙子", new User("紫霞仙子", "123456"));
        validUsers.put("菩提老祖", new User("菩提老祖", "123456"));
    }
    public static void addOfflineMessage(String userId, Message message){
        ArrayList<Message> messageList = null;
        if(offlineMessage.contains(userId)){
            messageList = offlineMessage.get(userId);
        }
        else{
            messageList = new ArrayList<Message>();
            offlineMessage.put(userId, messageList);
        }
        messageList.add(message);
    }
    public static ArrayList<Message> getOfflineMessage(String userId){
        ArrayList<Message> res = offlineMessage.get(userId);
        offlineMessage.remove(userId);
        return res;
    }
    //验证用户-密码
    private boolean checkUser(String userId, String password){
        boolean res = false;
        User user = validUsers.get(userId);
        if(user != null && password.equals(user.getPassword())){
            res = true;
        }
        return res;
    }
    public QQServer(){
        try {
            System.out.println("服务器在9999端口监听");
            //启动推送新闻的线程
            new Thread(new SendNewsToAllService()).start();
            serverSocket = new ServerSocket(9999);
            //接收多个客户端的连接请求，创建socket连接并读取输入的User对象，判断User信息是否正确
            //返回Message对象
            while (true){
                //如果没有客户端连接,服务器阻塞在这里
                Socket socket = serverSocket.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                User user = (User)objectInputStream.readObject();
                Message message = new Message();
                if(checkUser(user.getUserId(), user.getPassword())){
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //登录成功时，为了后续客户端与服务器的交互，需要创建一个线程，
                    objectOutputStream.writeObject(message);
                    // 该线程持有socket对象
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, user.getUserId());
                    serverConnectClientThread.start();
                    //将线程对象发到一个集合中管理
                    ManageClientThread.addClientThread(user.getUserId(), serverConnectClientThread);
                }
                else{
                    System.out.println(String.format("用户%s,登录失败，密码为:%s", user.getUserId(), user.getPassword()));
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    objectOutputStream.writeObject(message);
                    socket.close();
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //如果服务器退出循环，则说明服务器不再监听，需要关闭ServerSocket
            try {
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
