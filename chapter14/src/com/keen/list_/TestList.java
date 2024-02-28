package com.keen.list_;

import java.util.ArrayList;
import java.util.Iterator;

public class TestList {
    public static void main(String[] args) {
        //ArrayList是线程不安全的
        ArrayList list = new ArrayList();
        list.add("aa");
        list.add("bb");
        System.out.println(list.get(1));
        list.add(1,"cc");
        list.add("cc");
        System.out.println("first of \"cc\" is " + list.indexOf("cc") + "last is " + list.lastIndexOf("cc"));
        System.out.println("list = " + list);
        list.remove(1);
        System.out.println("list = " + list);
        list.set(1,"11");
        System.out.println("list = " + list);


        //List类遍历方式
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }

        System.out.println("使用增强for循环");
        for(Object i : list){
            System.out.println(i);
        }

        System.out.println("使用普通for");
        for(int i = 0; i < list.size(); ++i){
            System.out.println(list.get(i));
        }
        StringBuffer sb = new StringBuffer("1");
        for(int i = 0; i < 10; ++i) {
            System.out.println(String.format("%s\t2",sb));
            sb.append("1");
        }



    }
}
