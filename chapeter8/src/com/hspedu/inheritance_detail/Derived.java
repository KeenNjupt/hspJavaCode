package com.hspedu.inheritance_detail;

//java doesn't support multiple inheritance
public class Derived extends Base{
    //1.
    // in all constructor of Derived class, default call default Base() constructor
    // if Base class doesn't have Base(),  you must use super(xxx) to explicitly call Base(xxx) constructor
    // otherwise, there is an error

    //2.
    //super() can only be used in constructor, and super() statement must be the first statement in constructor
    //because this() statement must also be the first statement, so the super() statement and
    //this() statement can not exist in the same constructor

    //3. Object class is the base class of all classes
    //press ctrl + h to see the inheritance map
    public Derived() {
//        super();// default call super() function, super() will call Base() function
//        super(1);// explicitly call Base(int)()
        System.out.println("in Derived()");
    }
    public Derived(int n1){
        // defaul call super()
        //super(1);// explicitly call Base(int)()
        System.out.println("in Derived(int n1)");
    }

    public void test(){
        System.out.println("publicNum = " + publicNum + " protectedNum = " + protectedNum
        + " defaultNum = " + defaultNum + "privateNum = " + getPrivateNum());
        publicFunc();
        protectedFunc();
        defaultFunc();
        callPrivateFunc();
    }
}
