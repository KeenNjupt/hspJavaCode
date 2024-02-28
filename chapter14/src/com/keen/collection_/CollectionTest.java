package com.keen.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class CollectionTest {
    public static void main(String[] args) {
//        Collection
        ArrayList list = new ArrayList();
        list.add("keen");
        list.add("tom");
        list.add("macky");
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        list.remove("macky");
        System.out.println(list);
        System.out.println(list.contains("tom"));
        System.out.println(list.contains("keen"));
        System.out.println(list.size());
        list.clear();
        System.out.println(list);

        ArrayList list2 = new ArrayList();
        list2.add("first");
        list2.add("second");
        list.addAll(list2);

        ArrayList list3 = new ArrayList();
        list3.add("first");
        System.out.println(list2.containsAll(list3));
        list.add("third");
        System.out.println(list);
        list.removeAll(list2);
        System.out.println(list);
    }
}
