package com.keen.list_;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("1");//链表尾添加
        linkedList.add("2");
        linkedList.remove(); //删除链表头，返回删除的元素
        for(Object i : linkedList){
            System.out.println(i);
        }
        linkedList.set(0,999); //修改元素，编号从0开始
        System.out.println(linkedList);
        System.out.println(linkedList.get(0));
    }
}
