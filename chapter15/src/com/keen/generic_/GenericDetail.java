package com.keen.generic_;

import java.util.ArrayList;

public class GenericDetail {
    public static void main(String[] args) {
        //给泛型指定数据类型时，不能使用基本类型
//        ArrayList<int> arrayList = new ArrayList<int>();
        //两种创建泛型类对象的方式都可以
        ArrayList<AA> aas0 = new ArrayList<AA>();
        //推荐使用下面这种方式，编译器进行了类型推断
        ArrayList<AA> aas = new ArrayList<>();


        //等价于ArrayList<Object> list = new ArrayList<Object>();
        ArrayList list = new ArrayList();

    }
}

class AA{

}
