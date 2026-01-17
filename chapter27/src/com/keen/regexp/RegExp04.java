package com.keen.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp04 {
    public static void main(String[] args) {
        //选择匹配符 即匹配a或bc a|bc
        String content = "ab bcd";
        String regStr = "a|bc";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
