package com.keen.generic_;

public class SelfDefinedGenericFunction {
    public static void main(String[] args) {
        Boy boy = new Boy();
        boy.f(1);
        boy.f("1");
        GenericBoy<String> stringGenericBoy = new GenericBoy<>();
        stringGenericBoy.f(1);
        stringGenericBoy.f1("this");
        stringGenericBoy.f2(1.1f,"this");
    }

}

//可以在泛型类中使用泛型函数，也可以在常规类中使用泛型函数

class Boy{
    //常规类中使用泛型函数
    public <U> void f(U u){
        System.out.println(u.getClass());
    }
}

class GenericBoy<T>{
    //泛型类中使用泛型函数
    public <U> void f(U u){
        System.out.println(u.getClass());
    }

    //不是泛型类，T的类型为泛型类初始化时的指定类型，与类绑定
    public void f1(T t){

    }

    public <M> void f2(M m, T t){
        System.out.println(m.getClass());
        System.out.println(t.getClass());
    }
}
