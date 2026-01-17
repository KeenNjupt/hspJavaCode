package com.keen.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp05 {
    public static void main(String[] args) {
        //{n} 表示必须要出现n次 a{3} 表示匹配 aaa
        //[abcd]{3} 表示 abcd中任意一个字符连续出现三次 abc aaa aab aac

        //{n,m} 表示至少出现n次，最多出现m次，m可以不写 a{3,5} 匹配 aaa aaaa aaaaa
        //java匹配优先匹配长的字符串 aaaaaa a{3,5} 会匹配呈aaaaa

        //+ 表示出现1次到任意次 a+表示 a aa aaa ...
        //java为贪婪匹配 优先匹配长的字符串 aaaaa a+ 匹配aaaaa

        //* 表示出现0次到任意次
        //java为贪婪匹配 优先匹配长的字符串 a11111 a1* 匹配a11111

        //? 表示出现0次或1次 a?b 表示b ab
        //java为贪婪匹配 优先匹配长的字符串 a11111 a1? 匹配a1
        String content = "a1111111aaabcd";

//        String regStr = "a{2}";
//        String regStr = "[abc]{2}";
//        String regStr = "\\d{2}";

//        String regStr = "1{3,4}";

//        String regStr = "1+";

//        String regStr = "a1*";

        String regStr = "a1?";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()){
            System.out.println("find : " + matcher.group(0));
        }
    }
}
