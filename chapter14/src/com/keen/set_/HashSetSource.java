package com.keen.set_;

import java.util.HashSet;

public class HashSetSource {
    public static void main(String[] args) {
        /** HashSet底层是HashMap，添加元素时 调用map.put(e, PRESENT)
         * e为元素的key，对于HashSet来说元素的key即元素自身，PRESENT为一Object对象无实际意义
         * 1.通过元素得到一个hash值，该值作为索引值，调用HashMap.putVal(hash(key), key, value, false, true)
         * 2.按照位置 = 索引值&(存储数据的数组大小-1)，查看数组上该位置有没有元素，p = tab[i = (n - 1) & hash])
         * 该数组元素为链表节点，节点中包含 元素hash值，元素key，元素value
         * 3.若没有，将元素放到数组该索引位置上，作为初始链表
         * 4.若有，则遍历该位置上的链表，用hash值，key值是否相等判断元素是否相等
         * if (e.hash == hash &&
         *                         ((k = e.key) == key || (key != null && key.equals(k))))
         *若有相等元素则退出，若没有则在链表结尾添加该元素节点
         * 当链表长度>=7且表大小>=64时，将其树化， TREEIFY_THRESHOLD为8，MIN_TREEIFY_CAPACITY为64
         * p.next = newNode(hash, key, value, null);
         *                         if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
         *                             treeifyBin(tab, hash);
         *treeifyBin函数中
         * if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
         *             resize();
         */
        HashSet hashSet = new HashSet();
        hashSet.add("a");
        hashSet.add("b");
    }
}
