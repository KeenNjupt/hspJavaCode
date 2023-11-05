package com.keen.exception_;

/**
 * catch代码块和finally代码块必须有一个
 * 只用finally代码块时，程序会执行finally代码块中的语句，之后程序终止
 */
public class TryFinallyTest {
    public static void main(String[] args) {
        try{
            int n = 0;
//            int b = 2 / n;
            String[] list = new String[3];
            if(list[0].isEmpty()){
                System.out.println("list[0] is empty");
            }
        }
        finally {
            System.out.println("in finally");
        }
        System.out.println("程序继续执行");
    }
}
