package com.hspedu.reflection.dynamic_agent;

public class DynamicAgent {
    /**
     *代理设计模式：
     * 使用代理将对象包装起来，使用该代理对象取代原始对象。任何对原始对象的调用都要通过代理，
     *代理对象决定是否以及何时将方法调用转到原始对象上
     *
     * 动态代理：客户通过代理类来调用其他对象的方法，并且是在程序运行时根据需要动态创建目标类的代理对象
     * 需要解决的两个主要问题：
     *1. 如何根据加载到内存中的被代理类，动态地创建一个代理类及对象 (通过Proxy.newProxyInstance()实现)
     * 2. 当通过代理类的对象调用方法a时，如何动态地去调用被代理类中的同名方法a (通过InvocationHandler接口的实现类
     * 及其方法invoke())
     */
}
