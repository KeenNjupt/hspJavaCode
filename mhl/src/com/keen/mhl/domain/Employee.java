package com.keen.mhl.domain;

//java bean对应 employee表

/**
 * create table employee(
 *    id INT PRIMARY KEY AUTO_INCREMENT,
 *    empId varchar(50) UNIQUE NOT NULL DEFAULT '',
 *    pwd char(32) NOT NULL DEFAULT '',
 *    NAME varchar(50) NOT NULL DEFAULT '',
 *    job varchar(50) NOT NULL DEFAULT ''
 * );
 */
public class Employee {
    private Integer id;
    private String empId;
    private String pwd;
    private String name;
    private String job;

    //反射需要，默认构造函数
    public Employee(){

    }

    public Employee(Integer id, String empId, String pwd, String name, String job) {
        this.id = id;
        this.empId = empId;
        this.pwd = pwd;
        this.name = name;
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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
}
