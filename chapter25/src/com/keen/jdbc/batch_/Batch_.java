package com.keen.jdbc.batch_;

import com.keen.jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Batch_ {

    @Test
    public void noBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin1 values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();
        for(int i = 0; i < 5000; ++i){
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "123");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("no Batch time is" + (end-start));//6194
        JDBCUtils.close(connection, preparedStatement, null);
    }

    @Test
    public void Batch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        connection.setAutoCommit(false);
        String sql = "insert into admin values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();
        for(int i = 0; i < 5000; ++i){
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "123");
            //加入批量包
            //将sql语句预编译结果添加至 preparedStatement batchedArgs(ArrayList)中，elementData管理元素
            preparedStatement.addBatch();
            if( (i + 1) % 1000 == 0){
                //执行批量sql语句
                preparedStatement.executeBatch();
                connection.commit();
                //执行完成后，清空批量包
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Batch time is" + (end-start));//url上不加rewriteBatchedStatements=true 为4961,加上为 4595,调整为手动提交事务为416
        JDBCUtils.close(connection, preparedStatement, null);
    }
}
