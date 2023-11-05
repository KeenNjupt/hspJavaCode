package com.keen.exception_;

public class NumberFormatExceptionTest {
    public static void main(String[] args) {

        String num_string = "1234";
        int num = Integer.parseInt(num_string);
        System.out.println(num);

        String num_string2 = "123a";
        int num2 = 0;
        try {
            num2 = Integer.parseInt(num_string2);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println(num2);

    }
}
