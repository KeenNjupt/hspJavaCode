package com.hspedu.inheritance_detail;

public class Base {
    public int publicNum = 10;
    protected int protectedNum = 20;
    int defaultNum = 30;
    private int privateNum = 40;

    public Base() {
        System.out.println("in Base()");
    }

    public Base(int n1) {
        System.out.println("in Base(int n1)");
    }

    public void publicFunc(){
        System.out.println("in publicFunc()");
    }
    protected void protectedFunc(){
        System.out.println("in protectedFunc()");
    }
    void defaultFunc(){
        System.out.println("in defaultFunc()");
    }
    private void privateFunc(){
        System.out.println("in privateFunc()");
    }

    public int getPrivateNum() {
        return privateNum;
    }
    public void callPrivateFunc(){
        privateFunc();
    }
}
