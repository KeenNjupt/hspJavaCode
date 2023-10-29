package Enumeration;

public class EnumerationExercise {
    public static void main(String[] args) {
        Gender boy1 = Gender.BOY;
        Gender boy2 = Gender.BOY;
        System.out.println(boy1.toString());
        System.out.println(boy1==boy2);
        //oridinal为枚举对象的次序，从0开始编号
        System.out.println(boy1.ordinal());
        //valuse()返回定义中的所有枚举对象
        Gender[] list = Gender.values();
        for(Gender i : list){
            System.out.println(i);
        }
        //valueof()利用传入的字符串匹配定义的枚举对象，利用字符串和对象名匹配
        //匹配成功则返回枚举对象，匹配失败则报错
        Gender boy = Gender.valueOf("BOY");
        System.out.println(boy == boy1);
//        Gender boyx = Gender.valueOf("BOYx"); 报错
        //a.compareTo(b) => return a.ordinal - b.ordinal
        System.out.println(boy.compareTo(Gender.GIRL));

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
