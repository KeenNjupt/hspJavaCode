package com.keen.set_;

import java.util.LinkedHashSet;

public class LinkedHashSetSource {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        /*LinkedHashSet底层为LinkedHashMap
        1.add方法使用的父类HashSet的方法,只是在tab[i] = newNode(hash, key, value, null);时
        2.调用LinkedHashMap的newNode方法
        LinkedHashMap.Entry<K,V> p =
            new LinkedHashMap.Entry<K,V>(hash, key, value, e);
        linkNodeLast(p);
        return p;
        3.LinkedHashMap.Entry内部类继承了HashMap.Node内部类，其before和after属性
        用于形成双向链表
        static class Entry<K,V> extends HashMap.Node<K,V> {
            Entry<K,V> before, after;
            Entry(int hash, K key, V value, Node<K,V> next) {
                super(hash, key, value, next);
            }
        }
        4. linkNodeLast用于将新添加的元素节点连接到双向链表末尾，
        LinkedHashMap的head和tail属性表示双向链表的头和尾
        private void linkNodeLast(LinkedHashMap.Entry<K,V> p) {
            LinkedHashMap.Entry<K,V> last = tail;
            tail = p;
            if (last == null)
                head = p;
            else {
                p.before = last;
                last.after = p;
            }
        }
        5.总之，LinkedHashSet在HashSet基础上的改造为：将LinkedHashMap数组中元素设置为
        继承HashMap.Node的链表节点元素，在加入数组中时，将元素加入到双向链表中，
        LinkedHashMap的head和tail属性表示双向链表的头和尾

         */
        linkedHashSet.add("1");
        linkedHashSet.add("2");
        linkedHashSet.add("2");
        linkedHashSet.add("3");
        System.out.println(linkedHashSet);
    }
}
