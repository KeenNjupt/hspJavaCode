package com.keen.bean;

/**
 * java9中可以对接口类中的函数定义为private
 */

public interface MyInterface {
    //如下的三个方法的权限修饰符都是public
    void methodAbstract();

    static void methodStatic(){
        System.out.println("接口中的静态方法");
    }

    default void methodDefault(){
        System.out.println("接口中的默认方法");
    }

    private void methodPrivate(){
        System.out.println("接口中的私有方法");
    }
}
