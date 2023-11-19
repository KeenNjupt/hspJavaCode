package com.keen.String_;

public class StringBufferTest {
    public static void main(String[] args) {
        //StringBuffer继承AbstractStringBuilder类，该类中有属性char[] value存放字符数组
        //StringBuffer提供append方法拼接字符串
        String a = "abc";
        //String->StringBuffer
        //方式1
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a);
        //方式2
        StringBuffer stringBuffer1 = new StringBuffer(a);

        //StringBuffer->String
        //方式1
        String string = stringBuffer.toString();
        //方式2,利用String构造器
        String s = new String(stringBuffer1);

        System.out.println(stringBuffer);
        System.out.println(stringBuffer1);

        StringBuffer stringBuffer2 = new StringBuffer("0123456789");
        stringBuffer2.delete(5,8); //删除[5,8)位置上的字符，并将后面的字符向前填充
        System.out.println(stringBuffer2);
        stringBuffer2 = new StringBuffer("0123456789");
        stringBuffer2.replace(5,8,"abcdef");//将[5,8)位置上的字符，替换为"abcdef"
        System.out.println(stringBuffer2);
        int pos = stringBuffer2.indexOf("23");//返回第一次出现"23"的位置，没有则返回-1
        System.out.println(pos);
        stringBuffer2 = new StringBuffer("0123456789");
        stringBuffer2.insert(2,"abc");//在2位置上插入"abc",原来[2,count)位置上的字符后移
        System.out.println(stringBuffer2);



    }
}
