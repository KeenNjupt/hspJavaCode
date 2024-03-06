package com.keen.junit_;

import org.junit.jupiter.api.Test;

public class JUnitTest {
    public static void main(String[] args) {

    }

    //没有导入JUnit包时，使用alt+enter，选择导入Junit5.x包
    @Test
    public void m1(){
        System.out.println("in m1");
    }

    @Test
    public void m2(){
        System.out.println("in m2");
    }
}
