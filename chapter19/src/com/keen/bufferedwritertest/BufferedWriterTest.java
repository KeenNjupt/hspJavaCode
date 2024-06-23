package com.keen.bufferedwritertest;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest {
    @Test
    void testBufferedWriter() throws IOException {
        String filePath = "E:\\filewritertest.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true)); //追加模式
        bufferedWriter.write("line 1: 你好");
        bufferedWriter.newLine(); //插入一个和系统相关的换行符， windows crlf , linux lf
        bufferedWriter.write("line 2: 你好\n");
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}
