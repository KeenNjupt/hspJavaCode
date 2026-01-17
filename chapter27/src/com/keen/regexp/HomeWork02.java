package com.keen.regexp;

public class HomeWork02 {
    public static void main(String[] args) {
        /**
         * 验证是否是整数或小数，考虑正负 123 -456 12.345 -65.489 0.59 -0.59
         * 00123不行
         */

//        String content = "123";
        String content = "-01.45";
        //[-+]? 表示可以有正负号
        //([1-9]\\d*|0) 表示整数部分是0或是非零开头后面跟任意数字
        //(\\.\\d+)? 表示可以没有，若有的话包含一个. 和至少一个数字
        String regStr = "^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";
//        String regStr = "-?\\d+(\\.\\d+)";

        System.out.println(content.matches(regStr));
    }
}
