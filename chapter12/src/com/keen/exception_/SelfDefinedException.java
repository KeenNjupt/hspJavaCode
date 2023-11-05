package com.keen.exception_;

/**
 * 一般将自定义异常设置为RuntimeException的子类，这样可以使用java默认处理机制
 * 不用在函数方法中声明需要抛出的异常类型
 */
public class SelfDefinedException extends RuntimeException{
    public SelfDefinedException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        try{
            new Person().setAge(10);
        }
        catch (SelfDefinedException e){
            System.out.println(e.getMessage());
        }
    }
}

class Person{
    int age;

    public void setAge(int age) {
        if(age < 18 || age > 120){
            throw new SelfDefinedException("年龄应在[18,120]范围内，该年龄为：" + age);
        }
        this.age = age;
    }
}
