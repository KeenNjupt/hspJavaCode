package com.keen.standardinputoupttest;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class StandardInputOutputTest {
    public static void main(String[] args) {
//        test();
    }
    @Test
    void test(){


        /**
         * System.in为 System类的静态final属性 public final static InputStream in = null;
         * 其编译类型为java.io.InputStream
         * 其运行时类型为java.io.BufferedInputStream
         * 表示标准输入，即来自键盘的输入
         */
        System.out.println(System.in.getClass());

        /**
         * System.out 为 System类的静态final属性 public final static PrintStream out = null;
         * 其编译类型为java.io.PrintStream
         * 其运行时类型为java.io.PrintStream
         * 表示标准输出，即输出内容至显示器
         */
        System.out.println(System.out.getClass());

        System.out.println("输出内容至显示器");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入内容:");
        String next = scanner.next();
        System.out.println("输入内容为: " + next);
    }
}
