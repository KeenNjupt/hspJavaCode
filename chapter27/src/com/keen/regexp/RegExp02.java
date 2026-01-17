package com.keen.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp02 {
    public static void main(String[] args) {
        //演示转义字符的使用，比如要匹配特殊字符( ,需要使用转义字符
        String content = "abc$(.abc(123(";
        //匹配(, java中\\为转义符，其他语言可能是\
//        String regStr = "\\(";
        //匹配.
        String regStr = "\\.";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while(matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
