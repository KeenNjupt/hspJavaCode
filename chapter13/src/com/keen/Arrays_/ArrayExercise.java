package com.keen.Arrays_;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayExercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅新", 90);
        books[2] = new Book("青年文摘 20 年", 5);
        books[3] = new Book("java 从入门到放弃~", 300);
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return (int)(o2.price - o1.price);
            }
        });
        System.out.println(Arrays.toString(books));
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return (int)(o1.price - o2.price);
            }
        });
        System.out.println(Arrays.toString(books));
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.bookName.length() - o1.bookName.length();
            }
        });
        System.out.println(Arrays.toString(books));
    }
}

class Book {
    String bookName;
    double price;

    public Book(String bookName, double price) {
        this.bookName = bookName;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("bookName is %s, price is %d",bookName,(int)price);
    }
}
