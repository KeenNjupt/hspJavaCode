package com.keen.jdbc.datasource_;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class Druid_ {

    @Test
    public void testDruid() throws Exception{
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);



        long start = System.currentTimeMillis();
        for(int i = 0; i < 500000; ++i) {
            //从连接池中获取连接
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();//5000 303 500000 380
        System.out.println(end - start);
        System.out.println("连接成功");
        System.out.println("连接成功");

    }
}
