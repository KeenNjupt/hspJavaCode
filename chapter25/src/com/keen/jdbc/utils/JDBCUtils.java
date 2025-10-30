package com.keen.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 工具类，完成mysql的连接和关闭资源
 */
public class JDBCUtils {
    //定义相关属性

    private static String user;
    private static String password;
    private static String url;
    private static String driverName;
    //静态代码块去初始化
    static{
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysqlConn.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driverName = properties.getProperty("driver");
            url = properties.getProperty("url");
        } catch (IOException e) {
            //实际开发中，将该编译异常转为运行时异常抛出
            //这样，调用者可以选择捕获该异常，也可以默认处理
            throw new RuntimeException(e);
        }
    }

    //获取连接
    public static Connection getConnection()  {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //关闭相关资源
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }
}
