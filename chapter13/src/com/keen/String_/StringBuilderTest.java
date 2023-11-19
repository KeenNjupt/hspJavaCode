package com.keen.String_;

public class StringBuilderTest {
    public static void main(String[] args) {
        //StringBuilder实现了StringBuffer中的方法，但是它不保证多线程同步时程序能正常处理
        //可用于单线程的程序，其实现的方法比StringBuffer快
        StringBuilder stringBuilder = new StringBuilder();

        long stime = System.currentTimeMillis();
        for(int i = 0; i < 8000000; ++i){
            stringBuilder.append("abc");
        }
        // 结束时间
        long etime = System.currentTimeMillis();
        // 计算执行时间
        System.out.printf("执行时长：%d 毫秒.\n", (etime - stime));

        StringBuffer stringBuffer = new StringBuffer();

        stime = System.currentTimeMillis();
        for(int i = 0; i < 8000000; ++i){
            stringBuffer.append("abc");
        }
        // 结束时间
        etime = System.currentTimeMillis();
        // 计算执行时间
        System.out.printf("执行时长：%d 毫秒.\n", (etime - stime));

    }
}
