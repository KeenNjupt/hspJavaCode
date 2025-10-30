package com.keen.jdbc.myjdbc;

public class TestJdbc {
    public static void main(String[] args) {
        //通过jdbc接口完成对mysql的操作
        JdbcInterface jdbcInterface = new MysqlJdbcImpl();
        //通过接口来调用实现类 动态绑定
        jdbcInterface.getConnection();
        jdbcInterface.crud();
        jdbcInterface.close();

        //通过jdbc接口完成对oracle的操作
        jdbcInterface = new OracleJdbcImpl();
        //通过接口来调用实现类 动态绑定
        jdbcInterface.getConnection();
        jdbcInterface.crud();
        jdbcInterface.close();
    }
}
