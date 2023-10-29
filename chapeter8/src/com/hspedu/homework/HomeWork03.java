package com.hspedu.homework;

public class HomeWork03 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("kk", 10, "pro", 12,1.3);
        System.out.println(teacher.introduce());

        teacher = new Professor("tom",20,"pro",15,1.3);
        System.out.println(teacher.introduce());

    }
}

class Teacher{
    private String name;
    private int age;
    private String post;
    private double salary;
    private double salaryLevel;

    public Teacher(String name, int age, String post, double salary, double salaryLevel) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
        this.salaryLevel = salaryLevel;
    }
    public String introduce(){
        return "name = " + '\'' + name + '\'' +
                ", age = " + age +
                ", post = " + '\'' + post + '\'' +
                ", salary = " + salary +
                ", salaryLevel = " + salaryLevel;
    }
}

class Professor extends Teacher{

    public Professor(String name, int age, String post, double salary, double salaryLevel) {
        super(name, age, post, salary,salaryLevel);
    }

    @Override
    public String introduce() {
        return "the people is a professor, " + super.introduce();
    }
}

class AssociateProfessor extends Teacher{


    public AssociateProfessor(String name, int age, String post, double salary, double salaryLevel) {
        super(name, age, post, salary,salaryLevel);

    }

}

class lecturer extends Teacher{
    public lecturer(String name, int age, String post, double salary, double salaryLevel) {
        super(name, age, post, salary,salaryLevel);
    }


}