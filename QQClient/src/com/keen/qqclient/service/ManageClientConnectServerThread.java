package com.keen.qqclient.service;

import java.util.HashMap;

public class ManageClientConnectServerThread {
    //管理客户端产生的ClientConnectServerThread线程
    //key: userId, value:线程对象
    private static HashMap<String, ClientConnectServerThread> hashMap = new HashMap<>();
    public static void addClientConnectServerThread(String userId, ClientConnectServerThread clientConnectServerThread){
        hashMap.put(userId, clientConnectServerThread);
    }
    public static ClientConnectServerThread getClientConnectServerThread(String userId){
        ClientConnectServerThread clientConnectServerThread = hashMap.get(userId);
        return clientConnectServerThread;
    }
}
