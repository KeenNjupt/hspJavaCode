package com.keen.map_;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapSource {
    public static void main(String[] args) {
        //1. k-v 最后是 HashMap$Node node = newNode(hash, key, value, null)
        //2. k-v 为了方便程序员的遍历，还会 创建 EntrySet 集合 ，该集合存放的元素的类型 Entry, 而一个Entry
        //   对象就有k,v EntrySet<Entry<K,V>> 即： transient Set<Map.Entry<K,V>> entrySet;
        //3. entrySet 中， 定义的类型是 Map.Entry ，但是实际上存放的还是 HashMap$Node
        //   这时因为 static class Node<K,V> implements Map.Entry<K,V>
        //4. 当把 HashMap$Node 对象 存放到 entrySet 就方便我们的遍历, 因为 Map.Entry 提供了重要方法
        //   K getKey(); V getValue();

        HashMap hashMap = new HashMap();
        hashMap.put(new A(), new B());
        hashMap.put("1","first");
        hashMap.toString();

        Set set = hashMap.entrySet();
        for(Object o : set){
            Map.Entry entry = (Map.Entry) (o);
            System.out.println(entry.getClass());
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        Set set1 = hashMap.keySet();
        for(Object o : set1){
            System.out.println(o);
        }
        Collection values = hashMap.values();
        for(Object o : set){
            System.out.println(o);
        }

    }
}

class A{

}
class B{

}
