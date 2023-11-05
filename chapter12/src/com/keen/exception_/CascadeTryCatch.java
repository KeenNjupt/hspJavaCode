package com.keen.exception_;

/**
 * 多个catch块，程序按照书写顺序匹配异常，遇到第一个可以匹配的异常则不再继续匹配，
 * 可以匹配指抛出的异常可以赋值给cath()中声明的异常变量
 * 必须子类在前，否则编译器报错，因为如果父类在前面，子类的catch块永远不会被匹配
 * 没有父子关系的类不要求顺序
 */
public class CascadeTryCatch {
    public static void main(String[] args) {
        int a = 0;
        String s = null;
        try {
            System.out.println(s.length());
            int b = 10 / a;
        }
        catch (NullPointerException e){
            System.out.println(e.getClass());
        }
        catch (ArithmeticException e){
            System.out.println(e.getClass());
        }
        catch (RuntimeException e){
            System.out.println(e.getClass());
        }
        catch (Exception e) {
            System.out.println(e.getClass());
        }
    }
}
