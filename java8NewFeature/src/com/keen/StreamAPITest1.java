package com.keen;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPITest1 {

    //1-筛选与切片
    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();
        //filter(Predicate p) - 接收Lambda，从流中排除某些元素
        //查询员工列表中，姓名为keen的员工
        stream.filter(e -> e.getName() == "keen").forEach(System.out::println);

        //limit(n) 截断流，使其元素不超过给定数量，之前已经截断的流不可再次截断
        //如果下述语句 直接使用stream.limit 会报错
        list.stream().limit(1).forEach(System.out::println);
//        stream.limit(1).forEach(System.out::println); //报错

        //skip(n) 跳过元素，返回一个扔掉了前n个元素的流。
        //若流中元素不足n个，则返回一个空流
        list.stream().skip(1).forEach(System.out::println);
        System.out.printf("=====");
        //distinct() - 筛选，通过流所生成元素的hashCode 和 equals去除重复元素
        list.add(new Employee("keen",1, 15));
        list.stream().distinct().forEach(System.out::println);
    }

    //映射
    @Test
    public void test2(){
//        map(Function f) 接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每一个元素
        //并将其映射成一个新的元素
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        //练习：获取员工姓名长度大于3的员工的姓名
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().map(Employee::getName).filter( name -> name.length() > 3).forEach(System.out::println);

        //flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        //类似于 List.addAll
        //练习
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);
        System.out.println("========");
        streamStream.forEach( stream -> stream.forEach(System.out::println));

        System.out.println("========");
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::fromStringToStream);
        characterStream.forEach(System.out::println);

    }

    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String s){
        ArrayList<Character> characters = new ArrayList<>();
        for(Character c : s.toCharArray()){
            characters.add(c);
        }
        return characters.stream();
    }

    @Test
    public void test3(){
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        ArrayList list1 = new ArrayList();
        list1.add(4);
        list1.add(5);
        list1.add(6);

//        list.add(list1);
        list.addAll(list1);
        System.out.println(list);
    }

    //3-排序
    @Test
    public void test4(){
        //sorted 自然排序
//        List<Integer> list = Arrays.asList(12, 43, 65, 34, 0, -2, 5);
//        list.stream().sorted().forEach(System.out::println);

        //抛异常，原因：Employee没有实现Comparable接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com) 定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1, e2) -> Integer.compare(e1.getId(), e2.getId())).forEach(System.out::println);

    }
}
