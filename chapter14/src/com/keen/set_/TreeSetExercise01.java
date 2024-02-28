package com.keen.set_;

import java.util.TreeSet;

public class TreeSetExercise01 {
    public static void main(String[] args) {
        //由于TreeSet没有传入Comparator接口的类
        //则比较时使用 (Comparable<? super K>) key强制类型转换，但 P类没有实现Comparable接口
        //类型转换失败，抛出异常
        TreeSet treeSet = new TreeSet();
        treeSet.add(new P());
    }
}

class P{
    int a;
}
