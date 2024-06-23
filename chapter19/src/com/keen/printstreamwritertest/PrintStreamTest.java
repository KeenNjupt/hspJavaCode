package com.keen.printstreamwritertest;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {
    @Test
    public void test() throws IOException {
        //默认情况下，System.out输出位置为标准输出，即显示器
        PrintStream out = System.out;
        /**
         * print函数实际调用write方法
         *  public void print(String s) {
         *         if (s == null) {
         *             s = "null";
         *         }
         *         write(s);
         *     }
         */
        out.print("你好，world\n");
        //直接使用write方法输出
        out.write("再一次，你好，world\n".getBytes());
        //设置System.out为自定义的打印流，该流执行文件，打印流就是输出流
        PrintStream printStream = new PrintStream("E:\\test_system_out.txt");
        System.setOut(printStream);
        //输出至指定流中
        System.out.print("你好,world");


    }
}
