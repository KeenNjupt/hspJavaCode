package com.keen.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 介绍Matcher方法
 */
public class MatcherMethod {
    public static void main(String[] args) {
        String content = "hello keen this hello keen that hello";
        String regStr = "hello";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while(matcher.find()){
            System.out.println("=====");
            //start表示匹配字符串起始位置 groups[0]
            System.out.println(matcher.start());
            //end表示匹配字符串终止位置+1 groups[1]
            System.out.println(matcher.end());
            System.out.println(content.substring(matcher.start(), matcher.end()));
        }

        //校验整体匹配
        System.out.println(matcher.matches());

        //使用replaceAll进行字符串替换
        //将keen替换为jack
        regStr = "keen";
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(content);
        String newContent = matcher.replaceAll("jack");
        System.out.println("content = " + content);
        System.out.println("newContent = " + newContent);

    }
}
