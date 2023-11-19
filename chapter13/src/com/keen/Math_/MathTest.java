package com.keen.Math_;

public class MathTest {
    public static void main(String[] args) {
        int a = 2;
        int b = 7;
        int[] cnt = new int[b+1];
        for(int i = 0; i < cnt.length; ++i){
            cnt[i] = 0;
        }
        for(int i = 0; i < 100000000  ; ++i){
            int c = (int)(a + Math.random()*(b-a+1));
            cnt[c]++;
        }
        for(int i : cnt){
            System.out.println(i);
        }
    }
}
