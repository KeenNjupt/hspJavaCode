package com.keen.list_;

import java.util.Vector;

public class vector_ {
    public static void main(String[] args) {
        //无参构造器，默认大小为10
        //有参构造器，大小为参数
        //数组满了后，每次扩容一倍
        //int newCapacity = oldCapacity + ((capacityIncrement > 0) ? capacityIncrement : oldCapacity);
        //capacityIncrement参数在有参构造器Vector(int, int)时作为参数传入，表示每次扩容多少
        //Vector(int)构造函数，会将capacityIncrement值设为0
        Vector vector = new Vector();
        vector.add("1");

        Vector vector1 = new Vector(1);
        vector1.add("1");
        vector1.add("2");
    }
}
