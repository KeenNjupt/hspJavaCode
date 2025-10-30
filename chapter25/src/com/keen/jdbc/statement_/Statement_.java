package com.keen.jdbc.statement_;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Statement_ {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysqlConn.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);//不用写，但最好带上，表示进行注册了

        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();
//        String sql_name = "aaa";
//        String sql_password = "bbb";

        String sql_name = "1' or";
        String sql_password = "or '1' = '1";


        String sql = String.format("select name, password from user where name = '%s' and password = '%s'", sql_name, sql_password);
        System.out.println(sql);
        //ResultSet 中的 rowData.rows.elementData 数组存放每一行的数据
        //elementData中的元素有internalRowData 数组，存放一行中每一列的数据，数据为byte数组类型
        //字符和数字按照ascii编码，中文一个字符按照3个字符编码 utf8
        //resultset 的光标初始再第一行前面，调用next方法可以使光标向后移动
        //后面没有行时，next方法会返回false
        ResultSet resultSet = statement.executeQuery(sql);
//        //使用while循环遍历所有行
//        while(resultSet.next()){
//            String name = resultSet.getString(1);//取该行第一列
//            String result_password = resultSet.getString(2);//取该行第一列
//            System.out.println(String.format("%s %s", name, result_password));
//        }
        if(resultSet.next()){
            System.out.println("登录成功！");
        }
        else{
            System.out.println("登录失败！");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

}
