package com.keen.exception_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestFileException2RuntimeException {
    //可以将非运行时异常转为运行时异常，它们都有共同的父类Exception，Exception的父类为Throwable

    /**RuntimeException的构造函数为
     * public RuntimeException(Throwable cause) {
     *         super(cause);
     *     }
     *
     */
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("b.txt");
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
