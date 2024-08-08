package com.keen.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSocketServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        while(true) {
            datagramSocket.receive(datagramPacket);
            byte[] data = datagramPacket.getData();
            int length = datagramPacket.getLength();
            String s = new String(data, 0, length);
            String sendData = null;
            switch (s){
                case "四大名著是哪些":
                    sendData = "红楼梦，三国演义，水浒传，西游记";
                    break;
                default:
                    sendData = "what?";
                    break;
            }
            byte[] bytesSend = sendData.getBytes();
            DatagramPacket datagramPacketSend = new DatagramPacket(bytesSend, bytesSend.length, InetAddress.getByName("192.168.31.232"), 9999);
            datagramSocket.send(datagramPacketSend);
        }
//        datagramSocket.close();
    }
}
