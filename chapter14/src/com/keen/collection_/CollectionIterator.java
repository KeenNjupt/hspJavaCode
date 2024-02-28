package com.keen.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionIterator {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Book("C语言","K&R"));
        list.add(new Book("JAVA","..."));
        //用迭代器遍历collection，iterator方法为Iterable接口中的方法
        //iterator()生成一个迭代器，此时迭代器指向头元素的前一个位置
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){ //hasNext()判断下一个位置是否有元素
            Object next = iterator.next();//next()将迭代器指向下一个位置，并返回移动后位置上的元素
            System.out.println(next);
        }

        System.out.println("===========第二次遍历=======");
        iterator = list.iterator();
        //使用快捷键 itit 生成iterator遍历程序
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
        //利用增强for循环遍历Collection类,顶层实现为迭代器
        System.out.println("==========第三次遍历========");
        for(Object i : list){
            System.out.println(i);
        }
    }
}

class Book{
    String name;
    String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
