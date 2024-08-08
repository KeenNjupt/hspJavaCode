package com.keen.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPReceiver {
    public static void main(String[] args) throws IOException {
        //创建一个DatagramSocket对象，绑定至9999端口
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        //创建DatagramPacket对象
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        //接收UDP报文，并将报文内容传入DatagramPacket对象中，没有数据发送到监听端口时，
        // receive会阻塞
        datagramSocket.receive(datagramPacket);
        //对DatagramPacket对象进行拆包
        String s = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        System.out.println("在服务端接收到的信息为：" + s);
        byte[] byteData = "你好，我是服务端".getBytes();
        DatagramPacket datagramPacketSend = new DatagramPacket(byteData, byteData.length,
                InetAddress.getByName("192.168.31.232"), 8888);
        //发送UDP报文
        datagramSocket.send(datagramPacketSend);
        //关闭资源
        datagramSocket.close();
    }
}
