package com.keen.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc01 {
    public static void main(String[] args) throws SQLException {

        //前置工作：将jdbc驱动放置到IDEA项目库中
        //建一个libs目录用于存放驱动，将驱动放置到libs目录中，将libs目录右键，add as library

//        1.注册驱动-加载Driver类
        Driver driver = new Driver();
//        2.获取连接-得到Connection
        //jdbc:mysql表示协议名，使用jdbc连接mysql数据库
        //localhost:3306表示ip地址和mysql服务监听端口号
        //db02表示要连接的数据库
        //mysql连接本质上就是socket连接
        String url = "jdbc:mysql://localhost:3306/db02";
        //将用户名和密码放入Properties中
        //user和password的key值是固定的，不要修改
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","keen");

        Connection connect = driver.connect(url, properties);
//        3.执行增删改查-发送SQL给数据库执行
//        String sql = "insert into actor values(null, '刘德华2','男','1970-11-11','110')";
//        String sql = "update actor set name = '周星驰' where id = 1";
        String sql = "delete from actor where id = 1";
//        The object used for executing a static SQL statement and returning the results it produces
        //Statement 用于执行静态SQL语句，并返回其生成的结果对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "成功": "失败");
//        4.释放资源-关闭相关连接
        statement.close();
        connect.close();
    }
}
