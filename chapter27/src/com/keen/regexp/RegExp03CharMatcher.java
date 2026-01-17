package com.keen.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式元字符-字符匹配符
 */
public class RegExp03CharMatcher {
    public static void main(String[] args) {
        /**
         * [] 表示可接收的字符列表 [efgh] 表示 e f g h中的任意1个字符 [.]表示匹配字面量.
         * [^] 表示不可接收的字符列表 [^abc] 除 a b c 之外的任意1个字符
         * - 连字符 与两个字符搭配表示范围 [A-Z] 表示A-Z之间任意一个字符
         * . 匹配除\n之外的任何字符 a..b 表示开头是a中间任意两个字符结尾是b aaab
         * \\d 匹配单个数字字符 等价于[0-9] \\d{3}(\\d)? 包含三个或四个数字的字符串
         * \\d{3} 等价于 \\d\\d\\d, (\\d)?表示可以有数字也可以没有数字
         * \\D 匹配单个非数字字符 等价于[^0-9]
         * \\w 匹配单个字符，大小写英文字母字符相当于[0-9a-zA-Z]
         * \\W 匹配单个非字符、非大小写英文字母字符 相当于[^0-9a-zA-Z]
         */

        String content = "a11c8abcAbc_1! 2.";
//        String regStr = "\\d";//任意数字
//        String regStr = "\\D";//任意非数字
//        String regStr = "\\w";//任意英文字母、数字、下划线
//        String regStr = "\\W";//任意非（英文字母、数字、下划线）
//        String regStr = "\\s";//任意空白字符(空格、制表符等)
//        String regStr = "\\S";//任意非空白字符(空格、制表符等)
        String regStr = ".";//任意非.字符
//        Pattern pattern = Pattern.compile("[a-z]");
//        Pattern pattern = Pattern.compile("abc");//匹配abc字符串，默认区分大小写
//        Pattern pattern = Pattern.compile("(?i)abc");//匹配abc字符串，不区分大小写
//        Pattern pattern = Pattern.compile("abc", Pattern.CASE_INSENSITIVE);//表示匹配过程中不区分大小写
        //a(?i)bc 表示bc不区分大小写，a((?i)b)c 表示只有b不区分大小写
        //也可以用Pattern.compile("abc",Pattern.CASE_INSENSITIVE) 表示匹配过程中不区分大小写
//        Pattern pattern = Pattern.compile("[^a-z]");
//        Pattern pattern = Pattern.compile("[^a-z]{2}");
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while(matcher.find()){
            System.out.println("找到：" + matcher.group(0));
        }
    }
}
