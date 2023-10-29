package com.keen.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConn {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        connect5();
    }
    public static void connect5() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysqlConn.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);//不用写，但最好带上，表示进行注册了

        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println("方式5 " + connection);
    }
}
