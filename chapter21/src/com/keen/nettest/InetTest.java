package com.keen.nettest;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetTest {
    @Test
    public void testInetAddress() throws UnknownHostException {
        //本机InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        //通过主机名获得InetAddress对象
        InetAddress host2 = InetAddress.getByName("LAPTOP-VED6780C");
        System.out.println("host2 = " + host2);
        //通过域名获取
        InetAddress hostDomain = InetAddress.getByName("www.baidu.com");
        System.out.println("hostDomain = " + hostDomain);

        System.out.println(hostDomain.getHostAddress());
        System.out.println(hostDomain.getHostName());
    }
}
