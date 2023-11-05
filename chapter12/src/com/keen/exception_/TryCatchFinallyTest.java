package com.keen.exception_;


/**
 * try{
 *
 * }
 * catch(){
 *
 * }
 * finally{
 *
 * }
 * tyr代码块中若出现异常，则发生异常的语句之后的语句不会被执行
 * finally代码块不管try代码中会不会抛出异常都会执行
 * 当catch代码块中有throw语句时，finally代码块也会执行，finally代码块执行结束后函数就返回并抛出异常
 * finally代码块下面的语句不会执行
 * finally代码块通常放置释放资源的操作,finally中的return语句是函数的真正的返回语句
 */

public class TryCatchFinallyTest {
    public static void main(String[] args) {
//        try{
//            test();
//        }
//        catch (MyRuntimeException e){
//
//        }
//        System.out.println("the end of main()");
        System.out.println(testReturn());
    }

    public static int testReturn(){
        try{
            int b = 0;
            int a = 1 / b;
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
            return 1;
        }
        finally { //作为函数整体的返回语句
            return 2;
        }
    }

    public static void test(){
        try{
            f();
            System.out.println("end of test try");
        }
        catch (MyRuntimeException e){
//            e.printStackTrace();
            System.out.println("in test catch");
            throw e;
        }
        finally {
            System.out.println("in test finally");
        }
        System.out.println("the end of test()");
    }
    public static void f(){
        throw new MyRuntimeException("my runtime exception");
    }
}

class MyRuntimeException extends RuntimeException{
    MyRuntimeException(String message){
        super(message);
    }
}


