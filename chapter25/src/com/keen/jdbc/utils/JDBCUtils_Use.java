package com.keen.jdbc.utils;

import org.junit.Test;

import java.sql.*;

public class JDBCUtils_Use {

    @Test
    public void testDML(){
        Connection connection = JDBCUtils.getConnection();

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
            JDBCUtils.close(connection,preparedStatement,null);
        }
    }

    @Test
    public void testSelect(){
        Connection connection = JDBCUtils.getConnection();

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
            JDBCUtils.close(connection,preparedStatement,null);
        }
    }
}
