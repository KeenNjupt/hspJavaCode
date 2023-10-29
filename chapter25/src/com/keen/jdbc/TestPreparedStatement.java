package com.keen.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class TestPreparedStatement {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysqlConn.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);//不用写，但最好带上，表示进行注册了

        Connection connection = DriverManager.getConnection(url, user, password);
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入姓名：");
        String name = scanner.nextLine();
//        String sql = "select * from person where name = '" + name + "'";
//        System.out.println(sql);
//        Statement statement = connection.createStatement();
//        //执行查询语句，返回ResultSet对象
//        //输入 1' or '1 = 1 ，拼接的sql语句为select * from person where name = '1' or '1 = 1'
//        //发生sql注入
//        ResultSet resultSet = statement.executeQuery(sql);
//        if(resultSet.next()){
//            int age = resultSet.getInt(2);
//            System.out.println("name is " + name + ", age is " + age);
//        }
//        else{
//            System.out.println("failed");
//        }
        String sqlPre = "select * from person where ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlPre);
        //给？赋值
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            int age = resultSet.getInt(2);
            System.out.println("name is " + name + ", age is " + age);
        }
        else{
            System.out.println("failed");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

    }
}
