package com.keen.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式应用实例
 */
public class RegExp10Exercise {

    public static void main(String[] args) {
//        String content = "你好来了";
//        String content = "123890";
//        String content = "2414475788";
//        String content = "1378163146";
        String content = "https://www.bilibili.com/video/BV1fh411y7R8?spm_id_from=333.788.player.switch&vd_source=b4785f974e4a56857d21058cceaaf623&p=894";
        //表示开始到结尾直接至少有一个汉字，且只有汉字
//        String regStr = "^[\u0391-\uffe5]+$";

        //邮政编码:整体是1-9开头的六位数
//        String regStr = "^[1-9]\\d{5}$";

        //QQ号码：是1-9开头的5位-10位数
//        String regStr = "^[1-9]\\d{4,9}$";

        //手机号码：必须是以13 14 15 18 开头的11位数字
//        String regStr = "^1[3|4|5|8]\\d{9}$";

        //匹配URL，复杂正则表达式
        //先匹配http:// 或 https:// https?:// ?表示有或没有
        //在匹配后面的域名，如www.bilibili.com 有至少一个(数字英文字母-.)这样的组合组成+一个(数字英文字母-) ([\\w-]+\\.)+[\\w-]+
        //再匹配后面的内容，如 /video/BV1fh411y7R8?spm_id_from= 该部分可能有可能没有()? 用问号表示可以没有或有
        //(\\/[\\w-/.?=%&#]*)? [.] 中括号中的.?就表示匹配字面量
//        content="https://www.bilibili.com";
        String regStr = "^https?://([\\w-]+\\.)+[\\w-]+(\\/[\\w-/.?=%&#]*)?$";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        if(matcher.find()){
            System.out.println("匹配格式");
        }
        else{
            System.out.println("不匹配格式");
        }
    }
}
