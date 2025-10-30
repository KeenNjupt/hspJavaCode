package com.keen.jdbc.datasource_;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//使用DBUtils包来将resultset结果集转为对象数组
public class DBUtils_Use {

    @Test
    public void testQueryMany() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();

//        String sql = "select * from actor where id >= ?";
        String sql = "select id, name from actor where id >= ?"; //其余列中的封装结果为null
        /**
         * query 方法执行sql语句 -》 获取resultset -> 封装到ArrayList中
         * 返回 ArrayList
         * new BeanListHandler<>(Actor.class) 使用反射机制 获取Actor的属性，然后封装
         * 1 是给sql语句中的？赋值，可以有多个值，为可变形参
         * 会将获取到的resultset 和 preparedstatement 关闭
         */
        /** 源码
         * public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
         *         PreparedStatement stmt = null;
         *         ResultSet rs = null; //保存sql语句的resultset
         *         T result = null;//保存ArrayList<T>
         *
         *         try {
         *             stmt = this.prepareStatement(conn, sql); //获取prepareStatement
         *             this.fillStatement(stmt, params); //填充参数
         *             rs = this.wrap(stmt.executeQuery()); //获取resultset
         *             result = rsh.handle(rs);//将resultset中的每一行结果生成一个T对象
         *             //使用反射,Class对象的newInstance()创建T对象，根据类对象的属性类型调用对应的rs.getXXX(index)方法获取字段值
         *             //Method.invoke(T,value)方法设置对象值，setter.invoke(target, value);
         *         } catch (SQLException var33) {
         *             this.rethrow(var33, sql, params);
         *         } finally {
         *             try {
         *                 this.close(rs);
         *             } finally {
         *                 this.close((Statement)stmt);
         *             }
         *         }
         *
         *         return result;
         *     }
         */
        List<Actor> actorList = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);
        JDBCUtilsByDruid.close(connection,null,null);
        for( Actor i : actorList){
            System.out.println(i);
        }
    }
    //测试返回单条记录
    @Test
    public void testQuerySingle() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();

        String sql = "select id, name from actor where id = ?";
        //返回单个记录-单个对象，则使用BeanHandler
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 3);

        System.out.println(actor);
        JDBCUtilsByDruid.close(connection, null, null);
    }

    //测试查询单行单列
    @Test
    public void testQueryScalar() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();
        String sql = "select id from actor where id = ?";
        Object obj = queryRunner.query(connection, sql, new ScalarHandler(), 3);

        System.out.println(obj);

        JDBCUtilsByDruid.close(connection, null, null);
    }

    @Test
    public void testDML() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();

        QueryRunner queryRunner = new QueryRunner();

//        String sql = "update actor set name = ? where id = ?";
//        String sql = "insert into actor values(null,?,?,?,?)";
        String sql = "delete from actor where id = ?";

//        int affectedRows = queryRunner.update(connection, sql, "keen", 3);
//        int affectedRows = queryRunner.update(connection, sql, "赵", "女", "2025-01-01",null);
        int affectedRows = queryRunner.update(connection, sql, 1000);
        System.out.println(affectedRows);

        JDBCUtilsByDruid.close(connection, null, null);
    }
}
