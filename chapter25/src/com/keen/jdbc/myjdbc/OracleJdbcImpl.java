package com.keen.jdbc.myjdbc;

public class OracleJdbcImpl implements JdbcInterface{
    @Override
    public Object getConnection() {
        System.out.println("得到oracle数据库连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成oracle增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭oracle数据库连接");
    }
}
