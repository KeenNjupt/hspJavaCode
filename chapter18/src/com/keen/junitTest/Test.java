package com.keen.junitTest;

import java.awt.*;
import java.net.URL;
import java.util.Vector;

public class Test {
    @org.junit.jupiter.api.Test
    public void testVector(){
        Vector<String> strings = new Vector<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        for(int i = 0; i < strings.size(); ++i){
            String s = strings.get(i);
            if(s.equals("2") || s.equals("3")){
                strings.remove(s);
                i = i-1;
            }
        }
        System.out.println(strings);
    }
}
