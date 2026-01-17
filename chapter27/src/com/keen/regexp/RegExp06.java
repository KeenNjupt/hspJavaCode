package com.keen.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 定位符号 ^ $ \\b \\B
 */
public class RegExp06 {
    public static void main(String[] args) {
//        String content = "123-abc";
        String content = "keen123456keen 111keen";
        //^表示开始位置 以0-9至少一个字符开始跟着a-z任意一个字符的字符串
//        String regStr = "^[0-9]+[a-z]*";
        //$表示结束位置, 以0-9至少一个字符开始跟着一个短划线再以a-z至少一个字符结尾的字符串
//        String regStr = "^[0-9]+\\-[a-z]+$";
        //\\b表示边界 空格或结尾 keen\\b匹配 keen空格或keen结尾
//        String regStr = "keen\\b";


        //\\B表示非边界 空格或结尾 keen\\B匹配 keen非空格或keen非结尾
        String regStr = "keen\\B";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while(matcher.find()){
            System.out.println("find :" + matcher.group(0));
        }
    }
}
