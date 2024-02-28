package com.keen.set_;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        /*TreeSet默认构造器，底层TreeMap使用 key类默认的比较器，key需要实现Comparable接口
        Comparable<? super K> k = (Comparable<? super K>) key
        TreeMap底层插入元素简单逻辑为：
        1. 插入的第一个元素作为根节点
        2. 之后以插入二叉搜索树的方式插入新的元素，元素间的比较通过k.compareTo(t.key) t为当前节点
        比较值<0表示key < t，则向左子树查找，比较值 > 0则向右子树查找，比较值=0则将当前value设置为元素的value并返回
        若查找过程中当前节点为null则退出循环，根据比较值判断将新元素放置在父节点的左侧或右侧
        3. 插入后进行红黑树调整 fixAfterInsertion(e)

         */

        TreeSet treeSet = new TreeSet();
        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("sp");
        treeSet.add("a");

        System.out.println("treeSet = " + treeSet);

        /*TreeSet有参构造器，底层TreeMap使用传入的比较器
        new TreeMap<>(comparator)
        Comparator<? super K> cpr = comparator;
        TreeMap底层插入元素简单逻辑为：
        1. 插入的第一个元素作为根节点
        2. 之后以插入二叉搜索树的方式插入新的元素，元素间的比较通过cmp = cpr.compare(key, t.key); t为当前节点
        比较值<0表示key < t，则向左子树查找，比较值 > 0则向右子树查找，比较值=0则将当前value设置为元素的value并返回
        若查找过程中当前节点为null则退出循环，根据比较值判断将新元素放置在父节点的左侧或右侧
        do {
            parent = t;
            cmp = k.compareTo(t.key);
            if (cmp < 0)
                t = t.left;
            else if (cmp > 0)
                t = t.right;
            else
                return t.setValue(value);
        } while (t != null);

        Entry<K,V> e = new Entry<>(key, value, parent);
        if (cmp < 0)
            parent.left = e;
        else
            parent.right = e;
        3. 插入后进行红黑树调整 fixAfterInsertion(e)

         */

        TreeSet treeSet1 = new TreeSet(new Comparator() {
            //按照正常字符串比较顺序插入
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).compareTo((String) o2);
            }
        });

        treeSet1.add("jack");
        treeSet1.add("tom");
        treeSet1.add("sp");
        treeSet1.add("a");

        System.out.println("treeSet1 = " + treeSet1);

        TreeSet treeSet2 = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });


        treeSet2.add("jack");
        treeSet2.add("tom");
        treeSet2.add("sp");
        treeSet2.add("a");

        System.out.println("treeSet2 = " + treeSet2);
    }
}
