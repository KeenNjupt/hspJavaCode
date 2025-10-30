package com.keen.jdbc.preparestatement_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class PreparedStatement_ {
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


        String sql_name = "1' or";
        String sql_password = "or '1' = '1";

        //创建PreparedStatement时，需要给出sql语句，语句中的？相当于占位符
        String sql = "select name, password from user where name = ? and password = ?";
        //创建PreparedStatement对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //设置值 第一个参数是要设的SQL语句中的参数的索引（从1开始）
        //第二个是设置的SQL语句中的参数的值
        preparedStatement.setString(1, sql_name);
        preparedStatement.setString(2, sql_password);
//        String sql_name = "aaa";
//        String sql_password = "bbb";



        System.out.println(sql);
        System.out.println(String.format("select name, password from user where name = '%s' and password = '%s'", sql_name, sql_password));
        //ResultSet 中的 rowData.rows.elementData 数组存放每一行的数据
        //elementData中的元素有internalRowData 数组，存放一行中每一列的数据，数据为byte数组类型
        //字符和数字按照ascii编码，中文一个字符按照3个字符编码 utf8
        //resultset 的光标初始再第一行前面，调用next方法可以使光标向后移动
        //后面没有行时，next方法会返回false
        //preparedStatement执行executeQuery函数时，不用传入sql语句，其本身已经有sql语句了，如果传入
        //则会执行字面量的sql语句，因为有？会报错
//        ResultSet resultSet = preparedStatement.executeQuery(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
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
        preparedStatement.close();
        connection.close();
    }
}
