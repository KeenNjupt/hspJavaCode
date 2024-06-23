package com.keen.testproperties;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;


public class TestProperties {
    /**
     *
     * Properties的父类为HashTable,
     */
    @Test
    void testReadProperties() throws IOException {
        String filePath = "src/test.properties";
        FileReader fileReader = null;
        fileReader = new FileReader(filePath);
        Properties properties = new Properties();
        //从输入流中读取信息
        properties.load(fileReader);
        //将properties中的信息输出到指定设备，System.out指标准输出，即显示器
        properties.list(System.out);
        //通过getProperty函数获取对应键的值, 默认值为String类型
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println("user = " + user);
        System.out.println("password = " + password);

    }

    @Test
    void testWriteProperties() throws IOException {
        String filePath = "src/test2.properties";
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        //设置键值
        Properties properties = new Properties();
        properties.setProperty("user","testUser");
        properties.setProperty("password","中文1"); //中文字符会被转成unicode字符集的码点存储
        //写入properties文件中,覆写文件
        properties.store(fileOutputStream,"test");
    }
}
