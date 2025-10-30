package com.keen.dao_.dao;

import com.keen.jdbc.datasource_.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasicDAO <T>{ //泛型类
    private QueryRunner qr = new QueryRunner();
    //统一的dml
    private int update(String sql, Object... params){
        Connection connection = null;

        connection = JDBCUtilsByDruid.getConnection();
        int rows = 0;
        try {
            rows = qr.update(connection, sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {

            JDBCUtilsByDruid.close(connection,null,null);
        }

        return rows;
    }

    //返回多个对象，针对任意表
    /**
     *
     * @param sql sql语句可以有？
     * @param clazz 类的Class对象，如Actor.class
     * @param params ？的具体值
     * @return 返回clazz对应的类的List
     */
    public List<T> queryMulti(String sql, Class<T> clazz, Object... params){
        Connection connection = null;

        connection = JDBCUtilsByDruid.getConnection();
        List<T> res = null;
        try {
            res = qr.query(connection, sql, new BeanListHandler<>(clazz), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {

            JDBCUtilsByDruid.close(connection,null,null);
        }

        return res;
    }

    //返回单个对象，针对任意表
    /**
     *
     * @param sql sql语句可以有？
     * @param clazz 类的Class对象，如Actor.class
     * @param params ？的具体值
     * @return 返回clazz对应的类对象
     */
    public T querySingle(String sql, Class<T> clazz, Object... params){
        Connection connection = null;

        connection = JDBCUtilsByDruid.getConnection();
        T res = null;
        try {
            res = qr.query(connection, sql, new BeanHandler<>(clazz), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {

            JDBCUtilsByDruid.close(connection,null,null);
        }

        return res;
    }

    //返回单行单列，针对任意表
    /**
     *
     * @param sql sql语句可以有？
     * @param params ？的具体值
     * @return 返回对象
     */
    public Object queryScalar(String sql, Object... params){
        Connection connection = null;

        connection = JDBCUtilsByDruid.getConnection();
        Object res = null;
        try {
            res = qr.query(connection, sql, new ScalarHandler(), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {

            JDBCUtilsByDruid.close(connection,null,null);
        }

        return res;
    }

}
