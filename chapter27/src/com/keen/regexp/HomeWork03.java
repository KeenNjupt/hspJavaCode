package com.keen.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWork03 {
    public static void main(String[] args) {
        /**
         * 解析url 获取 协议 域名 端口 文件名
         * http://www.sohu.com:8080/abc/index.html
         * 协议 http
         * 域名 www.sohu.com
         * 端口 8080
         * 文件名 index.html
         */

        String content = "http://www.sohu.com:8080/abc/cdf/index.html";

        String regStr = "^(.+)://(.+):(\\d+)/(.)*/(.*)$";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        if(matcher.matches()){
            System.out.println(matcher.group(1) + " " +
                    matcher.group(2) + " " +
                    matcher.group(3) + " " +
                    matcher.group(5));
        }
    }
}
