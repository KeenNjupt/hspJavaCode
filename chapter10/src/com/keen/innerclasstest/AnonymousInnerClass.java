package com.keen.innerclasstest;


public class AnonymousInnerClass {
    public static void main(String[] args) {
        new A1().tiger.cry();
        new A1().acalss.f();
    }
}

class A1{
    //匿名内部类，该类只能使用一次,jdk生成一个内部类，并实例化一个对象返回
    //实际实现为
    /**
     * class A1$1 implents Animal{
     *    @Override
     *         public void cry() {
     *             System.out.println("老虎叫");
     *         }
     * }
     */
    Animal tiger = new Animal() {
        @Override
        public void cry() {
            System.out.println("老虎叫");
            System.out.println(this.getClass());
        }
    };

    /**实际实现为
     * class A1$2 extends Acalss(){
     *         @Override
     *         public void f() {
     *             System.out.println("anonymous inner class f()");
     *         }
     */
    Acalss acalss = new Acalss(){
        @Override
        public void f() {
            System.out.println("anonymous inner class f()");
            System.out.println(this.getClass());
        }
    };

}

interface Animal{
    public void cry();
}

class Acalss{
    public void f(){

    }
}
