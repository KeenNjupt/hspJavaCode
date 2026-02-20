package com.keen;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * java内置的4大核心函数式接口
 *
 * 消费型接口 Consumer<T> void accept(T t)
 * 供给型接口 Supplier<T> T get()
 * 函数型接口 Function<T,R> R apply(T t)
 * 断定型接口 Predicate<T> boolean test(T t)
 */

public class LambdaTest2 {

    @Test
    public void test1(){

        happyTime(200, new Consumer<Double>() {
            @Override
            public void accept(Double money) {
                System.out.println(String.format("消费%f元", money));
            }
        });
        System.out.println("=========");
        //使用Lambda表达式，创建函数式接口类对象
        happyTime(100, money -> System.out.println(String.format("消费%f元", money)));

    }
    //consumer对象有抽象方法 accept
    public void happyTime(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京","西安","东京");
        List<String> filterList = null;
        filterList = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterList);
        System.out.println("======");
        filterList = filterString(list, s -> s.contains("京"));
        System.out.println(filterList);
    }

    //根据predicate中test方法规则，过滤list中的字符串，返回符合规则的字符串列表
    public List<String> filterString(List<String> list, Predicate<String> predicate){
        ArrayList<String> filterList = new ArrayList<>();
        for(String s : list){
            if(predicate.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}
