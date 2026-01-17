package com.keen.regexp;

public class StringReg {
    public static void main(String[] args) {
        /**
         * String类中使用正则表达式
         */

        String content = "JDK1.1 JDK1.2 JDK is xxx";
        //替换 JDK1.1 JDK1.2 为JDK
        content = content.replaceAll("JDK1\\.(2|1)", "JDK");

        System.out.println(content);

        content = "13899999999";
        //验证手机号以138 137开头
        System.out.println(content.matches("13(8|7)\\d{8}"));

        content = "hello#world-come123here";
        //以 # - 数字分割字符串
        String[] split = content.split("#|-|\\d+");
        for(String i : split){
            System.out.println(i);
        }
    }
}
