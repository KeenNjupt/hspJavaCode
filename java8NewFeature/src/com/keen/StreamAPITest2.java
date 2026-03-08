package com.keen;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream的终止操作
 */

public class StreamAPITest2 {

    //1-匹配与查找
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        //allMatch(Predicate p) - 检查是否匹配所有元素
        //练习：是否所有的员工的年龄都大于18
        boolean b = employees.stream().allMatch(employee -> employee.getAge() > 18);
        System.out.println(b);

        //anyMatch(Predicate p) - 检查是否至少匹配一个元素
        //练习：是否存在员工的年龄大于 18
        boolean b1 = employees.stream().anyMatch(employee -> employee.getAge() > 18);
        System.out.println(b1);

        //noneMatch(Predicate p) - 检查是否没有匹配的元素，没有为true，有为false
        //练习：是否存在员工姓名开始为 ke
        boolean b2 = employees.stream().noneMatch(employee -> employee.getName().startsWith("ke"));
        System.out.println(b2);

        //findFirst - 返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

        //findAny - 返回当前流中的任意元素
        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);

        //count -返回流中元素的总个数
        long count = employees.stream().count();
        System.out.println(count);

        //max(Comparator c) 返回流中的最大值
        //练习返回最大的年龄
        Optional<Employee> max = employees.stream().max((e1, e2) -> e1.getAge() - e2.getAge());
        System.out.println(max);

        //min(Comparator c) 返回流中的最小值
        //练习：返回最小的年龄
        Optional<Employee> min = employees.stream().min((e1, e2) -> e1.getAge() - e2.getAge());
        System.out.println(min);

        //forEach(Consumer c) - 内部迭代
        employees.stream().forEach(new Consumer<Employee>() {
            @Override
            public void accept(Employee employee) {
                System.out.println(employee);
            }
        });
        System.out.println("======");
        employees.stream().forEach(employee -> System.out.println(employee));
        System.out.println("======");
        employees.stream().forEach(System.out::println);


    }

    @Test
    public void test2(){
        // reduce(T identity, BinaryOperator) 可以将流中元素反复结合起来，得到一个值 返回T
        //练习1：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        //reduce(BinaryOperator) 可以将流中元素反复结合起来，得到一个值 返回Optional<T>
        //练习2：计算公司所有员工年龄的总和
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Integer> ageStream = employees.stream().map(Employee::getAge);
//        Optional<Integer> reduce1 = ageStream.reduce(Integer::sum);
        Optional<Integer> reduce1 = ageStream.reduce((age1, age2) -> age1 + age2);
        System.out.println(reduce1);
    }

    //收集
    @Test
    public void test3(){
        //collect(Collector c) - 将流转换为其他形式。接收一个Collector接口的实现，将流转换为其他形式
        //练习1：查找年龄大于8岁的员工，结果返回一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(e -> e.getAge() > 8).collect(Collectors.toList());
        collect.forEach(System.out::println);

        Set<Employee> collect1 = employees.stream().filter(e -> e.getAge() > 15).collect(Collectors.toSet());
        collect1.forEach(System.out::println);

    }

}
