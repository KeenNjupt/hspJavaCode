package Enumeration;

public class EnumerationTest {
    public static void main(String[] args) {
//        System.out.println(Season.SPRING);
        System.out.println(SeasonEnum.SPRING);
    }
}


/**使用enum关键字定义枚举类型，默认继承Enum类,且各成员为static final
 *
 */

/**反编译SeasonEnum.class文件结果如下，javap SeasonEnum.class
 * Compiled from "EnumerationTest.java"
 * final class Enumeration.SeasonEnum extends java.lang.Enum<Enumeration.SeasonEnum> {
 *   public static final Enumeration.SeasonEnum SPRING;
 *   public static final Enumeration.SeasonEnum SUMMER;
 *   public static final Enumeration.SeasonEnum AUTUMN;
 *   public static final Enumeration.SeasonEnum WINTER;
 *   public static Enumeration.SeasonEnum[] values();
 *   public static Enumeration.SeasonEnum valueOf(java.lang.String);
 *   public java.lang.String toString();
 *   static {};
 * }
 */

    //定义的常量对象写在前面，且用逗号隔开，最后一个有分号
    //若调用无参构造器，则可以省略括号
enum SeasonEnum{
    SPRING("春季", "温暖"), SUMMER("夏季", "炎热"), AUTUMN("秋季", "凉爽"),
    WINTER("冬季", "寒冷"), WHAT;

    private String name;
    private String desc;

    private SeasonEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    //无参构造器
    private SeasonEnum(){

    }

    @Override
    public String toString() {
        return "SeasonEnum{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

/**
 * 自定义枚举类型
 * Season类四个对象表示四个季节，且不可以再创建新的其他Season类对象，不可修改对象属性
 */
class Season {
    private String name;
    private String desc;
    //创建四个Season对象，并且设置为public final static，可以再其他类直接调用
    public final static Season SPRING = new Season("春季", "温暖");
    public final static Season SUMMER = new Season("夏季", "炎热");
    public final static Season AUTUMN = new Season("秋季", "凉爽");
    public final static Season WINTER = new Season("冬季", "寒冷");

    //将构造器设为private，防止创建新的对象
    //不设置set方法
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}