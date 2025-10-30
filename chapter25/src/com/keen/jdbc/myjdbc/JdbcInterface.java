package com.keen.jdbc.myjdbc;

//jdbc接口
public interface JdbcInterface {
    //获取连接
    public Object getConnection();
    //crud操作
    public void crud();
    //关闭连接
    public void close();
}
