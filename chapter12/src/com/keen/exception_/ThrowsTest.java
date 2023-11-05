package com.keen.exception_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 对于编译异常，程序必须处理，用throws或者try-catch方式
 * 对于运行时异常程序默认为throws RuntimeException方式处理异常
 * throws指将该函数内出现的异常返回给函数的调用者，让调用者去处理
 * 若最终为JVM捕获该异常，JVM打印异常信息，终止程序
 */

/**
 * 继承和抛出异常throws
 * 子类重写父类方法时，若父类方法声明了抛出异常如 throws RuntimeException
 * 则子类重写的方法抛出的异常应为父类方法抛出异常自己或该异常的子类
 * 为了，不影响多态的使用，处理父类方法产生异常的方法可以正常使用在子类方法产生的异常
 */
public class ThrowsTest {
    public static void main(String[] args) {
        try{
            f();
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

    }

    public static void f() throws FileNotFoundException, RuntimeException{
        FileInputStream fileInputStream = new FileInputStream("b.txt");
        int a = 0;
        int b = 1 / a;
    }
}

class A{
    public void f() throws RuntimeException{

    }
}

class B extends A{
    @Override
    public void f() throws ArithmeticException {
    }
}
