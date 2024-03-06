package com.keen.generic_;

public class SelfDefinedGenericTest {
    public static void main(String[] args) {
        A<Integer> integerA = new A<Integer>(100);
        System.out.println(integerA);
        System.out.println(integerA.getClass());

        A<String> StringA = new A<String>("aaaa");
        System.out.println(StringA);
        System.out.println(StringA.getClass());
        A bbb = new A(1);//默认泛型类型为Object
        bbb.showClass();
    }
}

class A<T>{
    T something;
    //不能在静态变量和函数中使用泛型类型，不能new 泛型类型变量, 不能
    // 因为泛型类加载时不知道类型，无法为静态变量初始化内存空间
    //static T another;
    //T[] arr = new T[8];
    //T other = new T();
//    public static void f(T a){
//
//    }

    public A(T something) {
        this.something = something;
    }

    public void showClass(){
        System.out.println(something.getClass());
    }

    @Override
    public String toString() {
        return "A{" +
                "something=" + something +
                '}';
    }
}
