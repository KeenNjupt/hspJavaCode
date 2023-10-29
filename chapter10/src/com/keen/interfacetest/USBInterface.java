package com.keen.interfacetest;

public interface USBInterface { //接口默认是public的
    //接口中方法默认为public abstract
    int a = 10; //接口中成员变量都是public final static
    public void work();
    public void stop();
}
