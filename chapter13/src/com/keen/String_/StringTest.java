package com.keen.String_;

public class StringTest {
    public static void main(String[] args) {
        //1.String 类实现了java.io.Serializable接口，表示String类可以串行化，
        //串行化表示可以在网络上传输
        //2.String字符串的字符使用Unicode字符编码，一个字符（中文或英文）占两个字节
        //3.String有很多构造器
        //String(String s), String(char[] s), String(char[] s, int offset, int count)
        //String(byte[] s), String()
        //4.String类是final类，不可以被继承
        //5.String类中有属性 private final char value[]; char数组类型变量value为final类型
        //表示value中的值不能修改，即value不能被指向别的数组空间，但数组内的值可以被修改

        //创建String对象的两种方式
        //String s = "abc",在常量池中寻找有没有"abc"，若没有则创建，最终将"abc"的地址赋给s
        //String s = new String("abc"),在堆空间中创建String对象，将该对象的地址赋给s,
        //通过char[] value对象指向常量池中的"abc"
        String s1, s2;
        s1 = "abc";
        s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");
        if(s1 == s2){
            System.out.println("s1 == s2");
        }
        else{
            System.out.println("s1 != s2");
        }
        if(s3 == s4){
            System.out.println("s3 == s4");
        }
        else{
            System.out.println("s3 != s4");
        }
        //s3.intern()在常量池中寻找与s3中字符串相等的字符串（通过equals()来判断），若有则返回该字符串地址
        //没有则在常量池中添加该字符串，并返回字符串地址
        if(s1 == s3.intern()){
            System.out.println("s1 == s3.intern()");
        }
        else{
            System.out.println("s1 != s3.intern()");
        }
        if(s1 == "abc"){
            System.out.println("s1 == \"abc\"");
        }
        else{
            System.out.println("s1 != \"abc\"");
        }

        s1 = "def";

    }
}
