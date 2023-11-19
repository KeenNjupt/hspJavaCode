package com.keen.Calendar_;
import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();

        //Calendar对象中包含了时间信息，它没有格式化输出的方法，需要自己组合
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH);
        //月份从0开始，因此需要+1得到当前月份
        int day = instance.get(Calendar.DAY_OF_MONTH) + 1;
        int hour = instance.get(Calendar.HOUR_OF_DAY);
        int minute = instance.get(Calendar.MINUTE);
        int second = instance.get(Calendar.SECOND);
        int millisecond = instance.get(Calendar.MILLISECOND);
        System.out.println(String.format("%d %d %d %d:%d:%d",year,month,day,hour,minute,second,millisecond));

    }
}
