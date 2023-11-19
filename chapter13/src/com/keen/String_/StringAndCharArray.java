package com.keen.String_;

public class StringAndCharArray {
    public static void main(String[] args) {
        String s = new String("abc");
        char[] arr = {'c','d','e'};
        //在test函数中，str一开始指向s所指向的堆空间中的String对象
        //str = "cdf",使str指向常量池中的"cdf",但这并不改变s指向其原来的位置
        //但arr字符数组在函数中的改变会影响到数组本身
        test(s,arr);
        System.out.println(s);
        System.out.println(arr);
    }
    public static void test(String str, char[] arr){
        str = "cdf";
        arr[0] = 'a';
    }
}
