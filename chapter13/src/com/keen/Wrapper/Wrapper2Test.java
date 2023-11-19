package com.keen.Wrapper;

public class Wrapper2Test {
    public static void main(String[] args) {
        //包装器->字符串,三种方式
        Integer a = 10;
        String s;
        s = a + "";
        s = a.toString();
        s = String.valueOf(a);

        //字符串->包装器,两种方式:构造器和parseInt方法
        s = "1234";
        a = new Integer(s);
        a = Integer.parseInt(s);

    }
}
