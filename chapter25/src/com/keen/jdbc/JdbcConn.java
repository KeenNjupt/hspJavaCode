package com.keen.jdbc;

import com.mysql.jdbc.Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcConn {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//        connect1();
//        connect2();
//        connect3();
//        connect4();
        connect5();
    }

    public static void connect1() throws SQLException {

        //写死驱动类类型
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/db02";
        //将用户名和密码放入Properties中
        //user和password的key值是固定的，不要修改
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","keen");
        Connection connect = driver.connect(url, properties);
        connect.close();
        System.out.println("方式1 " + connect);
//
    }
    
    public static void connect2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        //使用反射加载Driver类，动态加载，更灵活
        String driverClassName = "com.mysql.jdbc.Driver";
        Class<?> driverClass = Class.forName(driverClassName);
        Driver driver = (Driver) driverClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/db02";
        //将用户名和密码放入Properties中
        //user和password的key值是固定的，不要修改
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","keen");
        Connection connect = driver.connect(url, properties);
        connect.close();
        System.out.println("方式2 " + connect);
    }

    public static void connect3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用DriverManager 注册驱动，管理驱动 获取连接
        String driverClassName = "com.mysql.jdbc.Driver";
        Class<?> driverClass = Class.forName(driverClassName);
        Driver driver = (Driver) driverClass.newInstance();
        //注册驱动
        DriverManager.registerDriver(driver);
        String url = "jdbc:mysql://localhost:3306/db02";
        //将用户名和密码放入Properties中
        //user和password的key值是固定的，不要修改
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","keen");

        Connection connection = DriverManager.getConnection(url, properties);
        connection.close();
        System.out.println("方式3 " + connection);
    }

    public static void connect4() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用DriverManager 管理驱动 获取连接
        //Class.forName 加载 com.mysql.jdbc.Driver 时 会自动完成注册驱动，无需手动注册
        //常用方式
        //mysql驱动5.1.6后 甚至可以不用Class.forName去加载类
        //因为jdk1.5以后使用的jdbc4, 无需显示调用Class.forName去加载类，而是会自动调用驱动jar包
        //下META-INF\services\java.sql.Driver文本中的类名称去注册
        //com.mysql.jdbc.Driver
        //但是还是加上Class.forName 表示使用哪种驱动
        /** 源码 static 的静态代码块会在类加载时执行，直接进行注册了
            static {
                try {
                    DriverManager.registerDriver(new Driver());
                } catch (SQLException var1) {
                    throw new RuntimeException("Can't register driver!");
                }
            }
         */
        String driverClassName = "com.mysql.jdbc.Driver";
        Class<?> driverClass = Class.forName(driverClassName);
        //无需注册驱动
        String url = "jdbc:mysql://localhost:3306/db02";
        String user = "root";
        String password = "keen";
        Connection connection = DriverManager.getConnection(url, user, password);
        connection.close();
        System.out.println("方式4 " + connection);
    }

    //使用配置文件，是连接方式更灵活，相关信息都在配置文件中
    public static void connect5() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysqlConn.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);//不用写，但最好带上，表示进行注册了

        Connection connection = DriverManager.getConnection(url, user, password);
        
        Statement statement = connection.createStatement();
        String sql = "update actor set name = 'keen' where id = 2";
        int rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "成功" : "失败");
        sql = "delete from actor where id = 3";

        rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "成功" : "失败");

        connection.close();
        System.out.println("方式5 " + connection);

    }
}
