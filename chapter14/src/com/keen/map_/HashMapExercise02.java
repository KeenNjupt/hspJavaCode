package com.keen.map_;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class HashMapExercise02 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("jack",650);
        hashMap.put("tom",1200);
        hashMap.put("smith",2900);
        System.out.println(hashMap);
        hashMap.put("jack",2600);
        System.out.println(hashMap);
        Set set = hashMap.keySet();
        for(Object o : set){
            int oldValue = (int)(hashMap.get(o));
            hashMap.put(o,oldValue + 100);
        }
        System.out.println(hashMap);
        System.out.println("name is ");
        for (Object o : set){
            System.out.println(o);
        }

        Collection values = hashMap.values();
        System.out.println("salary is ");
        for (Object o : values){
            System.out.println(o);
        }
    }
}
