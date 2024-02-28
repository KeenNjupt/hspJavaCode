package com.keen.set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("1");
        set.add(null);
        set.add(null);

        System.out.println("set = " + set);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for(Object i : set){
            System.out.println(i);
        }
    }
}
