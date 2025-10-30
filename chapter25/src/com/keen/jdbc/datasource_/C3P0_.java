package com.keen.jdbc.datasource_;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class C3P0_ {
    @Test
    public void testC3p0_1() throws Exception {
        //1.创建数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysqlConn.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driverName = properties.getProperty("driver");
        String url = properties.getProperty("url");
        //2.给数据源设置相关参数，连接管理由该数据源进行管理
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setDriverClass(driverName);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        //设置初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //设置最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
        long start = System.currentTimeMillis();
        for(int i = 0; i < 500000; ++i) {
            //从连接池中获取连接
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();//5000 270 500000 2085
        System.out.println(end - start);
        System.out.println("连接成功");
    }

    //使用配置文件的方式
    //将c3p0-config.xml文件 放置到src目录下
    //该文件中配置了连接信息和参数信息
    @Test
    public void testC3p0_2() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("keen");
        Connection connection = comboPooledDataSource.getConnection();
        connection.close();
        System.out.println("连接成功2");
    }
}
