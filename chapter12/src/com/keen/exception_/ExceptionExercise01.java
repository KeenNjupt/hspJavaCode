package com.keen.exception_;

public class ExceptionExercise01 {
    public static void main(String[] args) {
        try {
            int a = getInterge(getString(args,0));
            int b = getInterge(getString(args,1));
            System.out.println(div(a,b));
        } catch (Exception e) {
        }
    }

    public static String getString(String[] args, int index){
        String res = "";
        try{
            res = args[index];
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("数组越界，index = " + index);
            throw e;
        }
        return res;
    }

    public static int div(int a, int b){
        int res = 0;
        try{
            res = a / b;
        }
        catch (ArithmeticException e){
            System.out.println("除法出现异常，两个数分别为：" + a + " " + b);
            throw e;
        }
        return res;
    }
    public static int getInterge(String s){
        int res = 0;
        try{
            res = Integer.parseInt(s);
        }
        catch (NumberFormatException e){
            System.out.println("输入参数无法转化为数字，该参数为：" + s);
            throw e;
        }
        return res;
    }
}


