package com.keen.map_;

import java.util.HashMap;

public class HashMapExercise {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("1","aaa");
        hashMap.put("1","bbb"); //放入已有的key，则会替换已有的元素
        hashMap.put("2","aaa");

        System.out.println(hashMap);
    }
}
