package com.keen.bean;


import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class java9NewFeature {
    public static void main(String[] args) {
        test2();
    }

    @Test
    public void test1(){
        /**
         * java9 支持匿名类中的泛型类型推断
         */
        Comparator<Object> com = new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
    }


    public static void test2(){
        //java8之前的资源关闭

//        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
//        char[] charBuf = new char[20];
//
//        try {
//            int readLength = inputStreamReader.read(charBuf);
//            if(readLength != -1){
//                System.out.println(new String(charBuf, 0, readLength));
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            try {
//                if(inputStreamReader != null){
//                    inputStreamReader.close();
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }


        //java8中的资源关闭操作, 将需要自动关闭的资源放到try()中
        //可以实现资源的自动关闭，但是要求执行后必须关闭的所有资源必须在try子句中初始化，否则编译不通过
        try(InputStreamReader inputStreamReader = new InputStreamReader(System.in)){
            char[] charBuf = new char[20];
            int readLength = inputStreamReader.read(charBuf);
            if(readLength != -1){
                System.out.println(new String(charBuf, 0, readLength));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //java9中的资源关闭操作，可以将需要自动关闭资源的初始化放到try()外面
        //此时的资源变量是final，不能在try语句体中修改资源，多个资源可以用;隔开
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        try(inputStreamReader){
            char[] charBuf = new char[20];
            int readLength = inputStreamReader.read(charBuf);
            if(readLength != -1){
                System.out.println(new String(charBuf, 0, readLength));
            }
            //不能在try语句体中修改资源
//            inputStreamReader = null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * java9新特性：创建只读集合
     */
    @Test
    public void test3(){
        //java9中
        List<Integer> integers = List.of(1, 2, 3);
        //只读集合不允许修改
//        integers.add(5);


        //java8中
        List<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("a");
        stringArrayList.add("b");
        stringArrayList = Collections.unmodifiableList(stringArrayList);

        //修改只读集合会报错
//        stringArrayList.add("c");
        System.out.println(stringArrayList);

        //java8中
        List<String> list = Arrays.asList("a", "b");
//      修改只读集合会报错
//        list.add("c");


    }

    /**
     * java9新特性：InputStream新方法transferTo 把输入流中的所有数据复制到输出流中
     */
    @Test
    public void test4(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        try (InputStream resourceAsStream = classLoader.getResourceAsStream("hello.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("src\\hello1.txt")){
            resourceAsStream.transferTo(fileOutputStream);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * java9新特性：Stream API的加强
     */
    @Test
    public void test5(){

        List<Integer> list = Arrays.asList(23, 35, 55, 60, 8, 89, 7);
        //takeWhile遍历元素，一旦遇到不满足条件的就退出遍历，满足条件的会进行后续操作，如输出
        list.stream().takeWhile(x -> x < 60).forEach(System.out::println);
        System.out.println("=========");
        //dropWhile 遍历元素，一旦遇到不满足条件的，会对当前以及后续元素进行后续操作，如输出
        list.stream().dropWhile(x -> x < 60).forEach(System.out::println);
        System.out.println("=========");

        //of()参数中的多个元素，可以包含null值，但不能只包含null值
        Stream<Integer> integerStream = Stream.of(1, 2, 3, null);
        integerStream.forEach(System.out::println);

        //只包含null值时会报错
//        Stream<Object> objectStream = Stream.of(null);
//        objectStream.forEach(System.out::println);

        //ofNullable() 允许只包含null值
        Integer i = 10;
        i = null;
        Stream<Integer> i1 = Stream.ofNullable(i);
        System.out.println(i1.count());

        //重载的iterate
        //java8中的
        Stream.iterate(0, x -> x + 1).limit(10).forEach(System.out::println);
        System.out.println("======");
        //java9中的
        Stream.iterate(0, x -> x < 20, x -> x + 1).forEach(System.out::println);

        //java9新特性：Optional提供新的方法Stream
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");

        Optional<ArrayList<String>> list11 = Optional.ofNullable(list1);
        Stream<ArrayList<String>> stream = list11.stream();
        stream.flatMap(x -> x.stream()).forEach(System.out::println);

    }
}
