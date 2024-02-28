package com.keen.set_;

import java.util.HashSet;

public class HashSetIncrement {
    public static void main(String[] args) {
        /**
         * 1.HashSet第一次扩容时，将table数组扩容到16，static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
         * 加载因子为0.75，static final float DEFAULT_LOAD_FACTOR = 0.75f;
         * 阈值为newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY); 12
         * 2. 之后扩容（数组中元素(数组各位置上链表中的所有元素)超过阈值或一个位置上的链表元素超过7个），会将数组扩大两倍，阈值也会扩大两倍
         * else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
         *                      oldCap >= DEFAULT_INITIAL_CAPACITY)
         *                 newThr = oldThr << 1; // double threshold
         * 3. 当链表长度>=7且表大小>=64时，将其树化
         */
        HashSet hashSet = new HashSet();
        for(int i = 0; i < 100; ++i){
            hashSet.add(i);
        }
    }
}
