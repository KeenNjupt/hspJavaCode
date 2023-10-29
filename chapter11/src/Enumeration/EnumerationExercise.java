package Enumeration;

public class EnumerationExercise {
    public static void main(String[] args) {
        Gender boy1 = Gender.BOY;
        Gender boy2 = Gender.BOY;
        System.out.println(boy1.toString());
        System.out.println(boy1==boy2);
        System.out.println(boy1.ordinal());
    }
}

enum Gender{
    BOY,GIRL;

    /**父类Enum的构造器，name为变量名，ordinal为定义的顺序从0开始
     * protected Enum(String name, int ordinal) {
     *         this.name = name;
     *         this.ordinal = ordinal;
     *     }
     */
    /**父类Enum的toSting方法
     * public String toString() {
     *         return name;
     *     }
     */
}
