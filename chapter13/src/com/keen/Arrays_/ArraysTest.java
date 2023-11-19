package com.keen.Arrays_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysTest {
    public static void main(String[] args) {
        Integer arr[] = {2,1,4,8,3,9};
//        Arrays.sort(arr);//默认由小达到排序

        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, new Comparator<Integer>() { //通过Comparator<T>对象的compare方法决定比较规则，定制化排序
            //若compare(o1,o2) > 0则表示最后o1的排序在o2的右边
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //二分查找，要求数组有序,若数组中没有该元素，则返回 -(该元素应该在的位置 + 1)
        int value = 1;
        int index = Arrays.binarySearch(arr,value);
        System.out.println(String.format("the position of %d is %d",value,index));
        value = 5;
        index = Arrays.binarySearch(arr,value);
        System.out.println(String.format("the position of %d is %d",value,index));
        //将arr数组中所有元素替换为5
        Arrays.fill(arr,5);
        System.out.println(Arrays.toString(arr));

        //将数据转成Arrays的ArrayList静态内部类
        List<Integer> list = Arrays.asList(1, 3, 4, 5);
        System.out.println(list);
        System.out.println("list 的运行类型 " + list.getClass());

    }
}
