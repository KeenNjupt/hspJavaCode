package com.keen.jdbc.datasource_;

import com.keen.jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class JDBCUtilsByDruid_Use {

    @Test
    public void testDML(){
        System.out.println("use DruidJDBCUtils");
        Connection connection = JDBCUtilsByDruid.getConnection();

        String sql = "update actor set name = ? where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "周星驰");
            preparedStatement.setInt(2,2);
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows > 0 ? "成功":"失败");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(connection,preparedStatement,null);
        }
    }

    @Test
    public void testSelect(){
        System.out.println("use DruidJDBCUtils");
        Connection connection = JDBCUtilsByDruid.getConnection();

        String sql = "select * from actor";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String name = resultSet.getString("name");
                System.out.println(name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(connection,preparedStatement,null);
        }
    }

    //测试将resultset结果放入到ArrayList中
    @Test
    public void testSelectToArrayList(){
        System.out.println("use DruidJDBCUtils");
        Connection connection = JDBCUtilsByDruid.getConnection();

        String sql = "select * from actor";
        PreparedStatement preparedStatement = null;
        ArrayList<Actor> actors = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                Date bornDate = resultSet.getDate("bornDate");
                String phone = resultSet.getString("phone");
                actors.add(new Actor(id, name, sex, bornDate, phone));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(connection,preparedStatement,null);
        }
//        System.out.println("actors is " + actors);
        for(Actor i : actors){
            System.out.println(String.format("id is %d, name is %s", i.getId(), i.getName()));
        }
//        return actors;
    }
}
