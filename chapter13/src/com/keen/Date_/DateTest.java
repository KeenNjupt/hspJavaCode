package com.keen.Date_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        //获得当前日期时间
        Date date = new Date();
        //默认输出格式为英文习惯
        System.out.println(date);
        //使用日期格式转换类可以转换日期输出格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String formatDate = sdf.format(date);
        System.out.println(formatDate);

        String s = "2022年11月18日 11:52:26";
        try {
            //将对应的日期格式字符串转换为Date类型变量
            Date dateParse = sdf.parse(s);
            System.out.println(sdf.format(dateParse));

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
