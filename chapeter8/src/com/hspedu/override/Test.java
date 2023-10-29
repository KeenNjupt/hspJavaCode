package com.hspedu.override;


public class Test {
    public static void main(String[] args) {
        Derived derived = new Derived();
        derived.cry();
        Base base = (Base)derived;
        base.cry();
        Object fr = base.f1();
    }
}
