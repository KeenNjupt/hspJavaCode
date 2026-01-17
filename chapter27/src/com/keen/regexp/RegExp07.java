package com.keen.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 分组
 */
public class RegExp07 {

    public static void main(String[] args) {
        //(pattern) 非命名捕获。捕获匹配的子字符串。编号为零的第一个捕获是由整个正则表达式模式匹配的文本 mattcher.group(0)
        //其他捕获结果则根据左括号的顺序从1开始自动编号 group(1) group(2)

        //(?<name>pattern) 命名捕获。将匹配的子字符串捕获到一个组名称或编号名称中。用于name的字符串不能包含任何标点符号
        //，并且不能以数字开头，可以使用单引号替代尖括号，例如(?'name')

        String content = "abc 1122dcf44589dg";

//        String regStr = "(\\d\\d)(\\d\\d)";

        //通过命名捕获
        String regStr = "(?<g1>\\d\\d)(?<g2>\\d\\d)";
//        String regStr = "^(.*)$";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while(matcher.find()){

            System.out.println("find : " + matcher.group(0));
            System.out.println("group one : " + matcher.group(1));
            System.out.println("group one by group name : " + matcher.group("g1"));
            System.out.println("group two : " + matcher.group(2));
            System.out.println("group two by group name : " + matcher.group("g2"));
        }
    }
}
