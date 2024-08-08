package com.keen.homework;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPSocketClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        Scanner scanner = new Scanner(System.in);
        boolean isLoop = true;
        String s = null;
        while(isLoop){
            s = scanner.nextLine();
            byte[] bytes = s.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.31.232"), 8888);
            datagramSocket.send(datagramPacket);

            byte[] bytesReceive = new byte[1024];
            DatagramPacket datagramPacketReceive = new DatagramPacket(bytesReceive, bytesReceive.length);
            datagramSocket.receive(datagramPacketReceive);
            String receiveData = new String(datagramPacketReceive.getData(), 0, datagramPacketReceive.getLength());
            System.out.println(receiveData);
            if("quit".equals(s)){
                isLoop = false;
            }
        }
        datagramSocket.close();
    }
}
