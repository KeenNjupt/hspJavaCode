package com.keen.String_;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class StringExercise01 {
    public static void main(String[] args) {
        String a = "abc";
        String b = "def";
        //String c = a + b实际执行流程：
        //1. StringBuilder sb = new StringBuilder();
        //2. sb.append(a);
        //3. sb.append(b)
        //4. String c = sb.toString(); new String(value, 0, count);
        String c = a + b;
        char chnbegin = '\u4E00';
        char chnend = '\u9FFF';
        for(char ci = chnbegin; ci <= chnend; ++ci){
            System.out.print(ci + " ");
            if((ci - chnbegin + 1) % 10 == 0) System.out.println();
        }
        System.out.println((char)(chnend + 1));
        System.out.println((char)(chnbegin - 1));
        System.out.println(chnend - chnbegin + 1);


    }
}
