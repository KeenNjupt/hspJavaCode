package com.keen.process;

import java.io.IOException;

public class CpuTest {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        //当前可用cpu个数(核数)
        int cpuNum = runtime.availableProcessors();
        System.out.println(cpuNum);
    }
}
