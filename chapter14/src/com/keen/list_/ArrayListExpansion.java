package com.keen.list_;

import java.util.ArrayList;

public class ArrayListExpansion {
    public static void main(String[] args) {
        //ArrayList保存数据的变量为：transient Object[] elementData, transient表示该对象不会被序列化
        //ArrayList默认初始化时，该数组大小为0，this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        // 添加第一个元素时会将该数组大小扩容到10 DEFAULT_CAPACITY控制该值
        //之后数组大小不为0时，若当前数组已放满，则将数组大小扩大为原来的1.5倍 int newCapacity = oldCapacity + (oldCapacity >> 1);
        // 使用Arrays.copyof扩容：elementData = Arrays.copyOf(elementData, newCapacity);
        ArrayList list = new ArrayList();
        list.add("1");
        System.out.println(list);
        //按照传入的参数大小 创建相应大小的数组
        ArrayList list1 = new ArrayList(1);
        list1.add("1");
        list1.add("2");
        System.out.println(list1);
    }
}
