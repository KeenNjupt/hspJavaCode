package Enumeration;

public class EnumerationExercise02 {
    public static void main(String[] args) {
        Week[] values = Week.values();
        for(Week i : values){
            System.out.println(i);
            System.out.println(i.name());
        }
    }
}

//由于所有enum类都隐式继承了Enum类，所以enum类不能再继承其他类，java为单继承机制
//但可以实现其他接口
enum Week implements A{
    MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"), THURSDAY("星期四"),
    FRIDAY("星期五"), SATUARDAY("星期六"), SUNDAY("星期日");
    private String name;

    private Week(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void f() {

    }
}

interface A{
    public void f();
}

class B{

}
