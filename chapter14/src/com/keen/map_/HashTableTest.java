package com.keen.map_;

import java.util.Hashtable;

public class HashTableTest {
    public static void main(String[] args) {
        //Hashtable散列表，数组中存放链表
        //使用等同于HashMap，但Hashtable是线程安全的
        //Hashtable的key和value都必须不为空

        /*简单介绍
        Hashtable类中有一个内部类Hashtable$Entry[] 初始大小为11， 装载因子为0.75
        扩容机制为：当Hashtable中添加的元素数量 >= threshold, 进行扩容（put完成后才会增加元素数量计数）
        int newCapacity = (oldCapacity << 1) + 1;
        threshold = (int)Math.min(newCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
        之后将老表中元素放到扩容后的新表中
         */
        Hashtable hashTable = new Hashtable();
        hashTable.put("aa","b");
//        hashTable.put("1",null);
//        hashTable.put(null,"2");

    }
}
