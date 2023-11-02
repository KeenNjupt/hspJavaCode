package com.keen.exception_;

public class TestException {
    public static void main(String[] args) {
        //idea添加try-catch快捷键：选中代码块，ctrl+alt+t
        try {
            int res = 1 / 0;
        } catch (Exception e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("程序继续运行");
    }
}
