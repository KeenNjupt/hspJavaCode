package com.keen.LocalDateTime_;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {
    public static void main(String[] args) {
        //LocalDate中只存储年月日日期信息
        LocalDate localDate = LocalDate.now();
        System.out.println(String.format("%d %d %d",localDate.getYear(),localDate.getMonthValue(),localDate.getDayOfMonth()));
        //LocalTime中只存储时分秒信息
        LocalTime localTime = LocalTime.now();
        System.out.println(String.format("%d %d %d",localTime.getHour(),localTime.getMinute(),localTime.getSecond()));
        //LocalDateTime中存储了年月日时分秒日期信息
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("年=" + localDateTime.getYear());
        System.out.println("月=" + localDateTime.getMonth());
        System.out.println("月=" + localDateTime.getMonthValue());
        System.out.println("日=" + localDateTime.getDayOfMonth());
        System.out.println("时=" + localDateTime.getHour());
        System.out.println("分=" + localDateTime.getMinute());
        System.out.println("秒=" + localDateTime.getSecond());

        //用DateTimeFormatter类进行格式化输出
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(dtf.format(localDateTime));

        //LocalDateTime类提供了加减日期的方法
        LocalDateTime localDateTime1 = localDateTime.plusDays(7);
        System.out.println(dtf.format(localDateTime1));
        LocalDateTime localDateTime2 = localDateTime.plusDays(100);
        System.out.println(dtf.format(localDateTime2));
    }
}
