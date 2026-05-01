package com.keen;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;

public class DateTimeTest {

    /**
     * java.util.Date类 -> java.sql.Date
     * java.sql.Date对应数据库中的date类型
     * 1. 两个构造器的使用
     * 2.两个方法的使用
     * toString() 显示当前年、月、日、时、分、秒
     * getTime() 获取当前Date对象对应的毫秒数。(时间戳)
     */

    @Test
    public void test1(){
        long l = System.currentTimeMillis();
        System.out.println(l);
        //
    }

    /**
     * java8之前的时间类型API
     */
    @Test
    public void test2(){
        //Date() 创建一个对应当前时间的Date对象
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.getTime()); //1776179022523
        //创建指定毫秒数的Date对象
        Date date1 = new Date(1776179022523L);
        System.out.println(date1.toString());
        //java.sql.Date对象 是java.util.Date对象的子类
        java.sql.Date date2 = new java.sql.Date(1776179022523L);
        System.out.println(date2);

        //java.util.Date对象 转换为 java.sql.Date对象
        Date date3 = new Date();
        java.sql.Date date4 = new java.sql.Date(date3.getTime());
        System.out.println(date4);
    }


    /**
     * java8之前的时间类型API
     * SimpleDateFormat 对Date类日期对象进行格式化和解析
     * 1. 两个操作：
     * 1.1 格式化：日期 ----> 字符串
     * 1.2 解析：格式化的逆过程，字符串 ---> 日期
     *
     * 2.SimpleDateFormat的实例化
     */
    @Test
    public void test3() throws ParseException {
        //默认构造器
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        System.out.println(sdf.format(date));

        //指定构造器，格式化Date类日期对象
        String pattern = "YYYY-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        System.out.println(simpleDateFormat.format(date));

        String str = "2026-04-21 23:00:56";
        //解析字符串生成Date类对象
        System.out.println(simpleDateFormat.parse(str));

    }

    /**
     * Calendar日历类
     */
    @Test
    public void test4(){
        Calendar calendar = Calendar.getInstance();
        //当前时间是这个月的第几天
        //get
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //set
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //add
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //getTime 日历类 -> Date类
        System.out.println(calendar.getTime());

        //setTime Date -> 日历类
        Date date = new Date();
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

    }

    /**
     * jdk8中的时间API LocalDateTime
     */
    @Test
    public void test5(){
        //now() 获取当前时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of
        LocalDateTime localDateTime1 = LocalDateTime.of(2026, 4, 27, 13, 30, 20);
        System.out.println(localDateTime1);

        //get
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //修改 with
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(3);
        System.out.println(localDateTime2);

        //日期偏移
        LocalDateTime localDateTime3 = localDateTime.plusDays(2);
        System.out.println(localDateTime3);

    }

    /**
     * jdk8 中的时间API instant
     */
    @Test
    public void test6(){
        Instant instant = Instant.now(); //UTC时间 本初子午线时间，北京时间为东八区时间，需要在此基础上+8小时
        System.out.println(instant);//2026-04-28T14:54:45.832Z

        //使用atOffset函数 去掉偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2026-04-28T22:58:29.041+08:00

        //获取自1970年1月1日0时0分0秒(UTC)开始的毫秒数
        long epochMilli = instant.toEpochMilli();
        System.out.println(epochMilli); //1777388410356

        //通过毫秒数生成Instant实例
        Instant instant1 = Instant.ofEpochMilli(1777388410356L);
        System.out.println(instant1);//2026-04-28T15:00:10.356Z
    }

    /**
     * jdk8中的时间API DateTimeFormatter 格式化或解析日期、时间
     */
    @Test
    public void test7(){
        //创建DateTimeFormatter实例
        //方式1：预定义的标准格式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        //格式化日期 日期->字符串
        System.out.println(dateTimeFormatter.format(localDateTime));
        //解析：字符串->日期
        System.out.println(dateTimeFormatter.parse("2026-04-29T22:52:07.514"));

        //方式2
        //FormatStyle.LONG FormatStyle.MEDIUM FormatStyle.SHORT
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        System.out.println(dateTimeFormatter1.format(localDateTime));

        //方式3 自定义格式
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter2.format(localDateTime));
        System.out.println(dateTimeFormatter2.parse("2026-05-01 22:18:07"));

    }
}
