package com.keen.regexp;

import java.util.regex.Pattern;

/**
 * 介绍Pattern方法
 */

public class PatternMethod {
    public static void main(String[] args) {
        //Pattern.matches(regStr, content)方法返回true或false，表示是否匹配整个字符串
        String content = "hello keen";
        String regStr = "hello.*";

        System.out.println(Pattern.matches(regStr, content));
    }
}
