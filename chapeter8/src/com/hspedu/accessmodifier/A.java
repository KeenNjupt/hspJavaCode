package com.hspedu.accessmodifier;

public class A {
    //declare four access types of member variable and function
    public int publicNum = 10;
    protected int protectedNum = 20;
    int defaultNum = 30;
    private int privateNum = 40;

    public void publicFunc(){}
    protected void protectedFunc(){}
    void defaultFunc(){}
    private void privateFunc(){}

    public void test(){
        // in same class , can access four access types field and method
        System.out.println("publicNum = " + publicNum + " protectedNum = " + protectedNum + " defaultNum = " + defaultNum
        + " privateNum = " + privateNum);
        publicFunc();
        protectedFunc();
        defaultFunc();
        privateFunc();
    }
}
