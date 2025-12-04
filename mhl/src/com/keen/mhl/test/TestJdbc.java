package com.keen.mhl.test;
import com.keen.mhl.utils.JDBCUtilsByDruid;
import org.junit.Test;

import java.sql.Connection;

public class TestJdbc {
    @Test
    public void test(){
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println(connection);
    }
}
