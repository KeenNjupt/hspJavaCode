package com.keen.qqclient.view;

import com.keen.qqclient.service.FileClientService;
import com.keen.qqclient.service.MessageClientService;
import com.keen.qqclient.service.UserClientService;
import com.keen.qqclient.utils.Utility;

public class QQView {
    private boolean loop = true;
    private String key = "";
    private UserClientService userClientService = new UserClientService();
    private MessageClientService messageClientService = new MessageClientService();
    private FileClientService fileClientService = new FileClientService();

    public static void main(String[] args) {
        new QQView().mainMenu();
        System.out.println("=======客户端退出系统=======");
    }

    private void mainMenu(){
        while(loop){
            System.out.println("==========欢迎登录网络通信系统==========");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.println("请输入你的选择：");

            key = Utility.readString(1);
            switch (key){
                case "1":
                    System.out.println("登录系统");
                    System.out.println("请输入用户Id:");
                    String userId = Utility.readString(50);
                    System.out.println("请输入密 码:");
                    String password = Utility.readString(50);
                    //需要去服务端验证密码是否正确
                    boolean isCheck = userClientService.checkUser(userId, password);
                    if(isCheck){//密码匹配时
                        System.out.println("========欢迎用户(" + userId + ")登录成功========");
                        messageClientService.pullOfflineMessage(userId);
                        //进入二级菜单
                        while(loop){
                            System.out.println("\n========网络通信系统二级菜单(用户" + userId + ")========" );
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.println("请输入你的选择：");
                            String key = Utility.readString(1);
                            switch (key){
                                case "1":
//                                    System.out.println("显示在线用户列表");
                                    userClientService.onlineUserList();
                                    break;
                                case "2":
                                    System.out.println("请输入想说的话:");
                                    String content = Utility.readString(50);
                                    messageClientService.sendMessageToAll(content, userId);
                                    System.out.println("群发消息");
                                    break;
                                case "3":
                                    System.out.println("请输入想聊天的用户号(在线用户):");
                                    String receiveUserId = Utility.readString(50);
                                    System.out.println("请输入想说的话:");
                                    content = Utility.readString(50);
                                    messageClientService.sendMessageToOne(content, userId, receiveUserId);
                                    System.out.println("私聊消息");
                                    break;
                                case "4":
                                    System.out.println("发送文件");
                                    System.out.println("请输入想发送文件的用户号(在线用户):");
                                    receiveUserId = Utility.readString(50);
                                    System.out.println("请输入想发送文件的路径:");
                                    String src_file_path = Utility.readString(50);
                                    System.out.println("请输入想发送文件到对方的路径:");
                                    String dst_file_path = Utility.readString(50);
                                    fileClientService.sendFileToOne(src_file_path, dst_file_path, userId, receiveUserId);
                                    break;
                                case "9":
                                    System.out.println("退出系统");
                                    loop = false;
                                    userClientService.logout();
                                    break;
                            }
                        }
                    }
                    else{//登录服务器失败
                        System.out.println("========登录失败========");
                    }
                    break;
                case "9":
                    System.out.println("退出系统");
                    loop = false;
                    break;
            }
        }
    }
}
