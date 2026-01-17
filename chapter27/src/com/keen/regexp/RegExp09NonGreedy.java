package com.keen.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 非贪婪匹配 后面加?表示使用非贪婪匹配，匹配最短的
 */
public class RegExp09NonGreedy {
    public static void main(String[] args) {
        String content = "hello1111d";
        //默认贪婪匹配，匹配最长的
//        String regStr = "\\d+";
        //后面加?表示使用非贪婪匹配，匹配最短的
        String regStr = "\\d+?";


        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while(matcher.find()){
            System.out.println("find:" + matcher.group(0));
        }
    }

}
