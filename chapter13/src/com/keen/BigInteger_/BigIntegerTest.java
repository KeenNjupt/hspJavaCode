package com.keen.BigInteger_;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigIntegerTest {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("1234567894123456");
        BigInteger bigInteger1 = new BigInteger("111548885632563334584555");
        System.out.println(bigInteger1.add(bigInteger));
        System.out.println(bigInteger1.subtract(bigInteger));
        System.out.println(bigInteger1.divide(bigInteger));
        System.out.println(bigInteger1.multiply(bigInteger));

        BigDecimal bigDecimal = new BigDecimal("1.11111111112");
        BigDecimal bigDecimal1 = new BigDecimal("2.22");
        System.out.println(bigDecimal.add(bigDecimal1));
        System.out.println(bigDecimal.subtract(bigDecimal1));
        System.out.println(bigDecimal.multiply(bigDecimal1));
        //调用divide方法时，如果除法结果除不尽，则会抛出ArithmeticException异常
//        System.out.println(bigDecimal.divide(bigDecimal1));
        //使用BigDecimal.ROUND_CEILING指定精度，表示结果与分子精度保持一致
        System.out.println(bigDecimal.divide(bigDecimal1,BigDecimal.ROUND_CEILING));
    }
}
