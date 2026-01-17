package com.keen.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp13RemoveDuplicate {

    public static void main(String[] args) {
        String content = "我...我要...学学学...编程java";

        String regStr = "\\.";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        //去除.
        String newContent = matcher.replaceAll("");
        System.out.println(newContent);
        //将连续字符只取一个值
//        char c = content.charAt(0);
//        char lastChar = c;
//        StringBuilder sb = new StringBuilder();
//        sb.append(c);
//        for(int i = 1; i < newContent.length(); ++i){
//            c = newContent.charAt(i);
//            if(c != lastChar){
//                sb.append(c);
//            }
//            lastChar = c;
//        }
//        System.out.println(sb.toString());

        //正则表达式将连续字符只取一个值，思路：匹配多个连续字符，用该字符替换掉，也是基于贪婪匹配
        //匹配至少两个连续字符，第一个字符为分组1
        regStr = "(.)\\1+";
//        pattern = Pattern.compile(regStr);
//        matcher = pattern.matcher(newContent);
//        //外部反向引用，将匹配到的连续字符用单个字符替换
//        newContent = matcher.replaceAll("$1");

        //也可以用一行语句完成
        newContent = Pattern.compile(regStr).matcher(newContent).replaceAll("$1");
        System.out.println(newContent);
    }
}
