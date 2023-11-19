package com.keen.String_;

public class StringBufferExercise01 {
    public static void main(String[] args) {
        //将数字小数点前面每三位用逗号隔开
        //1234567.123 -> 1,234,567.123
        char[] ca = new char[1000];
        for(int i = 0; i < ca.length; ++i){
            ca[i] = (char)(i%10 + '0');
        }
        String s = new String(ca);
        long stime = System.currentTimeMillis();
        for(int i = 0; i < 8000000; ++i){
            f(s);
        }
        // 结束时间
        long etime = System.currentTimeMillis();
        // 计算执行时间
        System.out.printf("执行时长：%d 毫秒.\n", (etime - stime));


        stime = System.currentTimeMillis();
        for(int i = 0; i < 8000000; ++i){
            f2(s);
        }
        // 结束时间
        etime = System.currentTimeMillis();
        // 计算执行时间
        System.out.printf("执行时长：%d 毫秒.\n", (etime - stime));

        System.out.println(f(s));

        System.out.println(f2(s));
        s = "123456";
        System.out.println(f(s));
        System.out.println(f2(s));
        s = "123456.1";
        System.out.println(f(s));
        System.out.println(f2(s));

    }
    public static String f(String s){
        StringBuffer sb = new StringBuffer(s);
        int pointPos = sb.indexOf(".");
        if(pointPos == -1) pointPos = sb.length();
        int i = pointPos;
        while(true){
            i -= 3;
            if(i > 0){
                sb.insert(i,",");
            }
            else{
                break;
            }
        }
        return sb.toString();
    }
    public static String f2(String s){
        int pointPos = s.length();
        for(int i = s.length()-1; i >= 0; --i){
            if(s.charAt(i) == '.'){
                pointPos = i;
                break;
            }
        }
        int numlen = pointPos;
        int cntofComma = (numlen-1) / 3;
        char[] newArray = new char[s.length()+cntofComma];
        int i = s.length() - 1;
        int j = newArray.length - 1;
        while(i >= pointPos){
            newArray[j--] = s.charAt(i--);
        }
        while(true){
            if(i > 2 ){
                for(int k = 0; k < 3; ++k){
                    newArray[j--] = s.charAt(i--);
                }
                newArray[j--] = ',';
            }
            else{
                while(i >= 0){
                    newArray[j--] = s.charAt(i--);
                }
                break;
            }
        }
        return new String(newArray);
    }
}
