package com.keen.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWork01 {
    public static void main(String[] args) {
        //匹配电子邮箱
        //只能有一个@
        //@前面是用户名，只能有a-z A-Z 0-9 -字符组成
        //@后面跟着域名 域名非.的部分只能由英文字母组成如 sohu.org.cn

        String content = "keen0608@sohu.org.cn";

        String regStr = "^[\\w-]+@(([a-zA-Z])+\\.)+[a-zA-Z]+$";
//        String regStr = "[\\w-]+@";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

//        while(matcher.find()){
//            System.out.println("find: " + matcher.group(0));
//        }
        System.out.println(content.matches(regStr));
    }
}
