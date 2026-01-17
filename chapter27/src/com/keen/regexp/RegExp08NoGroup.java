package com.keen.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 演示非捕获分组
 */
public class RegExp08NoGroup {
    public static void main(String[] args) {
        String content = "hellokeen123 keen456 keen来了";
        //找到 keen123 keen456 keen来了
//        String regStr = "keen123|keen456|keen来了";

        //可使用非捕获分组实现，即匹配字符但不捕获，不存储供以后使用的匹配，不能用group(1)
        //等价于 "keen123|keen456|keen来了"
//        String regStr = "keen(?:123|456|来了)";
//        String regStr = "keen(123|456|来了)";//也可以进行捕获

        //找到keen这个字符串，但只匹配 keen123 和 keen456中的keen
        //keen(?=123|456) 只匹配 keen123 和 keen456中的keen
        //下面也是非捕获匹配，不能用group(1)
//        String regStr = "keen(?=123|456)";


        //找到keen这个字符串，但不匹配 keen123 和 keen456中的keen
        //keen(?!123|456) 不匹配 keen123 和 keen456中的keen
        //下面也是非捕获匹配，不能用group(1)
        String regStr = "keen(?!123|456)";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while(matcher.find()){
            System.out.println("find ：" + matcher.group(0));
//            System.out.println("find group(1)：" + matcher.group(1));
        }

    }
}
