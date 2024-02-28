package com.keen.collections_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("milan");
        list.add("tom");
        list.add("smith");
        list.add("jack");

        Collections.sort(list);
        System.out.println("list = " + list);

        Collections.sort(list, new Comparator(){
            @Override
            public int compare(Object o1, Object o2){
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        System.out.println("list = " + list);

        Collections.swap(list,1,3);
        System.out.println("list = " + list);

        String maxStr = (String)Collections.max(list);
        System.out.println(maxStr);
        String maxLenStr = (String)Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        System.out.println(maxLenStr);

        System.out.println("tom 出现的次数 : " + Collections.frequency(list,"tom"));

        ArrayList list1 = new ArrayList();
        for(int i = 0; i < list.size(); ++i){
            list1.add(null);
        }
        Collections.copy(list1,list);
        System.out.println("list1 = " + list1);

        Collections.replaceAll(list1,"tom","tomnew");
        System.out.println("list1 = " + list1);


    }
}
