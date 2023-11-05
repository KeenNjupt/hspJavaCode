package com.keen.exception_;

import java.util.Scanner;

/**
 * 当catch语句有return语句，但finally块中没有return语句时
 * catch return语句的返回值先压栈，在执行finally块中的代码
 * 函数最后返回压栈的值
 */
public class TryCatchExercise01 {
    public static void main(String[] args) {
//        System.out.println(test());
        System.out.println(getInteger());
    }
    public static int test(){
        int i = 0;
        try{
            int a = 0;
            int b = 10 / a;
        }
        catch (ArithmeticException e){
            return ++i;
        }
        finally {
            ++i;
            System.out.println("i = " + i);
        }
        return 0;
    }

    public static int getInteger(){
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        System.out.print("请输入正确的数字字符串：");
        int a = 0;
        do{
            try{
                a = Integer.parseInt(scanner.next());
                loop = false;
            }
            catch (RuntimeException e){
                System.out.print("输入错误，请输入正确的数字字符串：");
            }
        }while(loop);
        return a;
    }
}
