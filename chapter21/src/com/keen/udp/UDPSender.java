package com.keen.udp;

import java.io.IOException;
import java.net.*;

public class UDPSender {
    public static void main(String[] args) throws IOException {

        //创建一个DatagramSocket对象，使用8888端口
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        //创建DatagramPacket对象，并指定目标ip和端口号
        byte[] bytes = "你好，我是客户端".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.31.232"), 9999);
        //发送UDP报文
        datagramSocket.send(datagramPacket);
        byte[] bytesData = new byte[1024];
        DatagramPacket datagramPacketReceive = new DatagramPacket(bytesData, bytesData.length);
        //接收UDP报文，并将报文内容传入DatagramPacket对象中，没有数据发送到监听端口时，receive会阻塞
        datagramSocket.receive(datagramPacketReceive);
        //对DatagramPacket对象进行拆包
        String s = new String(datagramPacketReceive.getData(), 0, datagramPacketReceive.getLength());
        System.out.println("在发送端接收到的信息为：" + s);

        datagramSocket.close();
    }
}
