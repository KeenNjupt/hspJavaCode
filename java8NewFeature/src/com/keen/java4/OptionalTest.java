package com.keen.java4;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional类：为了在程序中避免出现空指针异常而创建的
 * 常用的方法：ofNullable(T t)
 * orElse(T t)
 */

public class OptionalTest {


    /**
     * Optional.of(T t) 创建一个Optional实例，t必须非空
     * Optional.empty() 创建一个空的Optional 实例
     * Optional.ofNullable(T t) t可以为null
     */
    @Test
    public void test(){
        Girl girl = new Girl();
//        girl = null;
//        Optional<Girl> optionalGirl = Optional.of(girl);
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        //orElse(T t)表示，如果Optional对象中的T对象为空则返回函数参数中的T对象，不为空则返回Optional对象中的T对象
        Girl girl1 = optionalGirl.orElse(new Girl("marry"));
        System.out.println(girl1);
    }

    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }

    @Test
    public void test2(){
        Boy boy = new Boy();
        boy = null;
        System.out.println(getGirlName(boy));
    }
    //常规优化后的getGirlName,避免空指针异常
    public String getGirlNameConsiderNull(Boy boy){
        String res = null;
        if( boy != null){
            Girl girl = boy.getGirl();
            if( girl != null){
                res = girl.getName();
            }
        }
        return res;

    }


    @Test
    public void test3(){
        Boy boy = new Boy();
//        boy = null;
        System.out.println(getGirlNameConsiderNull(boy));
    }

    //使用Optional类的getGirlName函数，防止空指针异常
    public String getGirlNameWithOptional(Boy boy){
        Boy defaultBoy = new Boy();
        Girl defaultGirl = new Girl("sherry");
        defaultBoy.setGirl(defaultGirl);

        Optional<Boy> boy1 = Optional.ofNullable(boy);
        //boy2 一定非空
        Boy boy2 = boy1.orElse(defaultBoy);
        Girl girl = boy2.getGirl();
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        //girl1 一定非空
        defaultGirl.setName("kevin");
        Girl girl1 = optionalGirl.orElse(defaultGirl);
        return girl1.getName();
    }

    @Test
    public void test5(){
        Boy boy = null;
        boy = new Boy();
        boy.setGirl(new Girl("merry"));

        System.out.println(getGirlNameWithOptional(boy));
    }
}
