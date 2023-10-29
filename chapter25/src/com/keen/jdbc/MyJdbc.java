package com.keen.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MyJdbc {
    public static void main(String[] args) throws SQLException {
        //注册驱动
        Driver driver = new Driver();
        //建立连接
        //jdbc:mysql表示协议名，使用jdbc连接mysql数据库
        //localhost:3306表示ip地址和mysql服务监听端口号
        //mydatabase表示要连接的数据库
        //mysql连接本质上就是socket连接
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        Properties properties = new Properties();
        //设置用户名和密码
        properties.setProperty("user","root");
        properties.setProperty("password","root");
        //得到连接
        Connection connect = driver.connect(url, properties);

        //要执行的sql语句
        String sql = "select * from person";
        //创建Statement对象
        Statement statement = connect.createStatement();
        //执行查询语句，返回ResultSet对象
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            String name = resultSet.getString(1);
            int age = resultSet.getInt(2);
            System.out.println("name is " + name + ", age is " + age);
        }
        resultSet.close();
        statement.close();
        connect.close();
    }

}
