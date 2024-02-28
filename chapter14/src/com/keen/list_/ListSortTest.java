package com.keen.list_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ListSortTest {
    public static void main(String[] args) {
        //List list = new ArrayList();
        List list = new LinkedList();
        //List list = new Vector();
        list.add(new Book("红楼梦", "曹雪芹", 100));
        list.add(new Book("西游记", "吴承恩", 10));
        list.add(new Book("水浒传", "施耐庵", 19));
        list.add(new Book("三国", "罗贯中", 80));
        //list.add(new Book("西游记", "吴承恩", 10))
//        Object[] array = list.toArray();
//        Arrays.parallelSort(array,new Comparator() {
//            public int compare(Object o1, Object o2){
//                Book b1 = (Book)o1;
//                Book b2 = (Book)o2;
//                return b1.price - b2.price;
//            }
//        });
//        System.out.println(Arrays.toString(array));
        bubbleSort(list);
        System.out.println(list);
    }

    public static void bubbleSort(List list){
        int len = list.size();
        for(int j = len - 1; j > 0; --j){
            for(int i = 0; i < j; ++i){
                Book b1 = (Book)list.get(i);
//                System.out.println("b1 == list.get(i)" + (b1 == list.get(i)));
                Book b2 = (Book)list.get(i+1);
                if(b1.compare(b2) > 0){
                    list.set(i,b2);
//                    System.out.println("after set b2, b1 == list.get(i)" + (b1 == list.get(i)));
                    list.set(i+1,b1);
//                    System.out.println(b1==b2);
                }
            }
        }
    }
}

class Book {
    String name;
    String author;
    int price;

    public Book(String name, String author, int price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }
    public Book(Book b){
        this.name = b.name;
        this.author = b.author;
        this.price = b.price;
    }
    public int compare(Book b){
        return this.price - b.price;
    }

    @Override
    public String toString() {
        return "Book{" + "name='" + name + '\'' + ", author='" + author + '\'' + ", price=" + price + '}';
    }
}
