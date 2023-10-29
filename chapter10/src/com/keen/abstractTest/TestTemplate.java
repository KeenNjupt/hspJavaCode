package com.keen.abstractTest;

public class TestTemplate {
    public static void main(String[] args) {
        new AA().calTimes();
        new BB().calTimes();

    }
}

abstract class Template{
    public abstract void job(); //抽象方法
    public void calTimes(){
        long start = System.currentTimeMillis();
        job(); //子类调用calTimes方式时，job方法通过动态绑定机制，调用子类自己的方法
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
    }
}

class AA extends Template{
    @Override
    public void job() {
        for(int i = 1; i < 8000000; ++i){
            int j = i +1;
        }
    }
}

class BB extends Template{
    @Override
    public void job() {
        for(int i = 1; i < 800000000; ++i){
            int j = i * 2;
        }
    }
}
