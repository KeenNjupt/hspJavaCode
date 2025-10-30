package com.keen.jdbc.transcation_;

import com.keen.jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction_ {
    //db02
    //create table account_test(id int primary key auto_increment, name varchar(32), balance double);
    //insert into account_test values(null, '马云',3000);
    //insert into account_test values(null, '马化腾',10000);

    @Test
    public void noTransaction(){
        Connection connection = JDBCUtils.getConnection();

        String sql1 = "update account_test set balance = balance - 100 where id = 1";
        String sql2 = "update account_test set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql1);
            int rows = preparedStatement.executeUpdate();

            int a = 1/0;//人为异常退出
            preparedStatement = connection.prepareStatement(sql2);
            rows = preparedStatement.executeUpdate();
            System.out.println(rows > 0 ? "成功":"失败");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(connection,preparedStatement,null);
        }
    }

    @Test
    public void Transaction(){
        Connection connection = JDBCUtils.getConnection();

        String sql1 = "update account_test set balance = balance - 100 where id = 1";
        String sql2 = "update account_test set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        try {
            connection.setAutoCommit(false);//关闭事务自动提交，开启事务
            preparedStatement = connection.prepareStatement(sql1);
            int rows = preparedStatement.executeUpdate();

//            int a = 1/0;//人为异常退出
            preparedStatement = connection.prepareStatement(sql2);
            rows = preparedStatement.executeUpdate();
            System.out.println(rows > 0 ? "成功":"失败");
            connection.commit();//全部成功时，则提交

        } catch (SQLException e) {
            try {
                connection.rollback();//回滚
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(connection,preparedStatement,null);
        }
    }
}
