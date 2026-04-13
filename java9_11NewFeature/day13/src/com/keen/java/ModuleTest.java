package com.keen.java;

import com.keen.bean.Person;
//使用module-info.java导入需要使用的模块，被使用的模块也要在module-info.java中暴露模块
public class ModuleTest {


    public static void main(String[] args){
        Person person = new Person("tom",12);
        System.out.println(person);
    }

}
