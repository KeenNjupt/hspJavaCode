package com.keen.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp12GroupCaptureBackQuote {
    public static void main(String[] args) {
        /**
         * 分组：圆括号组成的正则表达式，可以看作子表达式/一个分组
         * 捕获：匹配的分组，保存到groups数组中 组0表示整个字符串
         *  groups[0] = 整个匹配字符串开始位置 ， 该字符串结束的索引位置+1记录到groups[1]中
         *  groups[2] = 第一组开始位置  groups[3] = 第一组结束位置+1
         * groups[4] = 第二组开始位置  groups[5] = 第二组结束位置+1
         *
         * 反向引用：圆括号的内容被捕获后，可以在这个括号后被使用，称为反向引用
         * 正则表达式内部使用的反向引用\\分组号，外部反向引用$分组号，外部应用指不在正则表达式中引用
         * 而是在匹配后引用
         */

        String content = "hello jack tom11 cat22222 12345 5115 12345-333999111-12345-343999111";

        //两个连续相同的数字, (\\d)匹配数字，\\1反向引用该数字
//        String regStr = "(\\d)\\1";
        //匹配五个连续相同的数字
//        String regStr = "(\\d)\\1{4}";
        //匹配个位与千位相同的数字，百位和十位相同的数字
//        String regStr = "(\\d)(\\d)\\2\\1";

        //前面是一个五位数，跟着一个-,后面是九位数，连续的三位要相同，如12345-333999111
        String regStr="\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while(matcher.find()){
            System.out.println("find:" + matcher.group(0));
        }
    }
}
