package com.keen.jdbc.preparestatement_;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class PreparedStatementDML_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        //预处理statement可以解决sql注入问题、减少编译次数，效率较高
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysqlConn.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);//不用写，但最好带上，表示进行注册了

        Connection connection = DriverManager.getConnection(url, user, password);


        String sql_name = "aab";
        String sql_password = "aaap";

        //创建PreparedStatement时，需要给出sql语句，语句中的？相当于占位符
//        String sql = "insert into user(name, password) values(?,?) ";
//        String sql = "update user set name = ? where password = ?";
        String sql = "delete from user where name = ? ";
        //创建PreparedStatement对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //设置值 第一个参数是要设的SQL语句中的参数的索引（从1开始）
        //第二个是设置的SQL语句中的参数的值
        preparedStatement.setString(1, sql_name);
//        preparedStatement.setString(2, sql_password);
//        String sql_name = "aaa";
//        String sql_password = "bbb";



        System.out.println(sql);
        int rows = preparedStatement.executeUpdate();
        System.out.println(rows > 0 ? "成功":"失败");
        preparedStatement.close();
        connection.close();
    }
}
