package com.keen.qqserver.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ManageClientThread {
    private static HashMap<String, ServerConnectClientThread> hashMap = new HashMap<String, ServerConnectClientThread>();
    public static void addClientThread(String userId, ServerConnectClientThread thread){
        hashMap.put(userId, thread);
    }
    public static void removeClientThread(String userId){
        hashMap.remove(userId);
    }
    public static ServerConnectClientThread getClientThread(String userId){
        return hashMap.get(userId);
    }
    public static String getOnlineUser(){
        StringBuffer stringBuffer = new StringBuffer();
        boolean isFirst = true;
        for(String userId : hashMap.keySet()){
            if(isFirst){
                stringBuffer.append(userId);
                isFirst = false;
            }
            else{
                stringBuffer.append(" ");
                stringBuffer.append(userId);
            }
        }
        return stringBuffer.toString();
    }
    public static List<String> getOnlineUserList(){
        ArrayList<String> userList = new ArrayList<>();
        for(String userId : hashMap.keySet()){
            userList.add(userId);
        }
        return userList;
    }
}
