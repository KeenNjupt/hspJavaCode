package com.keen.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 探讨java正则表达式底层原理
 */
public class RegTheory {
    public static void main(String[] args) {
        String content = "1995年，1996互联网的蓬勃发展给了Oak机会。" +
                "业界为了使死板、单调的静态网页能够“灵活”起来，急需一种软件技术来开发一种程序，" +
                "这种程序可以通过网络传播并且能够跨平台运行。于是，世界各大IT企业为此纷纷投入了大量的人力、" +
                "物力和财力。这个时候，Sun公司想起了那个被搁置起来很久的Oak，" +
                "并且重新审视了那个用软件编写的试验平台，由于它是按照嵌入式系统硬件平台体系结构进行编写的，" +
                "所以非常小，特别适用于网络上的传输系统，而Oak也是一种精简的语言，程序非常小，" +
                "适合在网络上传输。Sun公司首先推出了可以嵌入网页并且可以随同网页在网络上传输的Applet" +
                "（Applet是一种将小程序嵌入到网页中进行执行的技术），并将Oak更名为Java。" +
                "5月23日，Sun公司在Sun world会议上正式发布Java和HotJava浏览器。" +
                "IBM、Apple、DEC、Adobe、HP、Oracle、Netscape和微软等各大公司都纷纷停止了自己的相关开发项目，" +
                "竞相购买了Java使用许可证，并为自己的产品开发了相应的Java平台。";
        //目标：匹配所有四个数字
        // \\d 表示任意一个数字
        String regStr = "\\d\\d\\d\\d";
        //创建模式对象 即正则表达式对象
        Pattern pattern = Pattern.compile(regStr);
        //创建匹配器 matcher， 按照正则表达式的规则 去匹配content字符串
        Matcher matcher = pattern.matcher(content);
        //开始匹配
        /**
         * match.find() 的工作
         * 1. 根据指定的规则，定位满足规则的子字符串(1995)
         * 2. 找到后，将子字符串的开始的索引 记录到matcher对象的属性 int[] groups;数组中
         * groups[0] = 开始位置 0， 该子字符串结束的索引位置+1记录到groups[1]中，groups[1] = 3+1 = 4
         * 3. 同时更新oldLast = groups[1]
         * matcher.group
         * public String group(int group) {
         *         if (first < 0)
         *             throw new IllegalStateException("No match found");
         *         if (group < 0 || group > groupCount())
         *             throw new IndexOutOfBoundsException("No group " + group);
         *         if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
         *             return null;
         *         return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
         *     }
         *     返回 groups[0*2], groups[0*2+1] 的 content的subString
         *
         *  下一次find时同理
         */
        while(matcher.find()){
            System.out.println("找到：" + matcher.group(0));
        }

        //考虑分组 ()包裹的部分为一组，下面的模式共有两组
        regStr = "(\\d\\d)(\\d\\d)";
        //创建模式对象 即正则表达式对象
        pattern = Pattern.compile(regStr);
        //创建匹配器 matcher， 按照正则表达式的规则 去匹配content字符串
        matcher = pattern.matcher(content);
        //开始匹配
        /**
         * match.find() 的工作 考虑分组
         * 1. 根据指定的规则，定位满足规则的子字符串(1995) 第一个()表示第一组匹配到19 第二个()表示第二组匹配到95
         * 2. 找到后，将子字符串的开始的索引 记录到matcher对象的属性 int[] groups;数组中
         * groups[0] = 开始位置 0， 该子字符串结束的索引位置+1记录到groups[1]中，groups[1] = 3+1 = 4
         * groups[2] = 第一组开始位置 0 groups[3] = 第一组结束位置+1 = 2
         * groups[4] = 第二组开始位置 2 groups[5] = 第二组结束位置+1 = 4
         * 有更多组则依次类推
         * 3. 同时更新oldLast = groups[1]
         * matcher.group
         * public String group(int group) {
         *         if (first < 0)
         *             throw new IllegalStateException("No match found");
         *         if (group < 0 || group > groupCount())
         *             throw new IndexOutOfBoundsException("No group " + group);
         *         if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
         *             return null;
         *         return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
         *     }
         *     返回 groups[0*2], groups[0*2+1] 的 content的subString
         *
         *  下一次find时同理
         */
        while(matcher.find()){
            //getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString()
            //group(0) 表示匹配到的子字符串
            //group(1) 表示匹配到的子字符串的第一组子串
            //group(2) 表示匹配到的子字符串的第二组子串
            System.out.println("找到：" + matcher.group(0));
            System.out.println("第一组为：" + matcher.group(1));
            System.out.println("第二组为：" + matcher.group(2));
        }
    }


}
