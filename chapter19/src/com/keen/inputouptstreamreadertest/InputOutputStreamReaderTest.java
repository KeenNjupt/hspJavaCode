package com.keen.inputouptstreamreadertest;

import org.junit.jupiter.api.Test;

import java.io.*;

public class InputOutputStreamReaderTest {
    @Test
    void test() throws IOException {
//        String filePath = "E:\\file_encoding.txt";
        String filePath = "E:\\file_encoding_ansi.txt";
        //使用FileReader字符流读取文本文件，默认使用utf-8编码解码文件
        //若源文件编码为其他格式，如ANSI格式，则输出会乱码
        //ansi编码为windows独有的编码，它不是一种特定的编码，而是windows抽象出的编码，用于表示本地编码
        //如在中国则为GBK编码，在美国则为ascii编码，在韩国则为EUC-KR编码，台湾为big-5编码
        //微软用一个叫“Windows code pages”（在命令行下执行chcp命令可以查看当前code page的值）的值来判断系统默认编码，
        // 比如：简体中文的code page值为936（它表示GBK编码，win95之前表示GB2312），繁体中文的code page值为950（表示Big-5编码）
        //详细见：https://www.cnblogs.com/malecrab/p/5300486.html
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String s = bufferedReader.readLine();
        System.out.println(s);
        bufferedReader.close();

        //使用InputStreamReader将FileInputStream字节流转换为字符流，并指定编码格式
        //解决编码格式不匹配导致乱码问题
        InputStreamReader gbkReader = new InputStreamReader(new FileInputStream(filePath), "gbk");
        BufferedReader bufferedReader1 = new BufferedReader(gbkReader);
        String s1 = bufferedReader1.readLine();
        System.out.println(s1);
        bufferedReader1.close();
    }

    @Test
    void testOutputStreamWriter() throws IOException {
        String charSet = "gbk";
        String filePath = String.format("E:\\outputStreamWriter_%s.txt", charSet);
        //1.创建流对象, 将FileOutputStream字节流转换为OutputStreamWriter字符流，并指定编码格式
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), charSet);
        // 2.写入
        osw.write("hello,韩顺平教育~");
        // 3.关闭
        osw.close();
        System.out.println("保存成功~");
    }
}
