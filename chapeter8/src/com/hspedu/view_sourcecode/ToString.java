package com.hspedu.view_sourcecode;

public class ToString {
    public static void main(String[] args) {
        /*Object.toString()
        getClass.getName()return the name of class with package name
        Integer.toHexString(hashCode()) return the hex code of hashcode
        public String toString() {
            return getClass().getName() + "@" + Integer.toHexString(hashCode());
        }
         */

        Monster monster = new Monster("kk", "climb", 10);
        System.out.println(monster.toString());
        System.out.println(monster);// equals to System.out.println(monster.toString());
    }
}

class Monster{
    private String name;
    private String job;
    private double salary;

    public Monster(String name, String job, double salary) {
        setName(name);
        setJob(job);
        setSalary(salary);
    }

    //override the toString() function, output the member variable of object
    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
