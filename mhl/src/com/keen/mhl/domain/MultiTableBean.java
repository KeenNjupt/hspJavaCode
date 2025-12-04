package com.keen.mhl.domain;

import java.util.Date;
//存放多表查询结果的bean
public class MultiTableBean {
    private Integer id;
    private String billId;
    private Integer menuId;
    private Integer nums;
    private Double money;
    private Integer dinningTableId;
    private Date billDate;
    private String state;
    //如果sql查询的列名与属性名不一致，则反射调用set列名函数设置对象值时找不到函数导致值为null
    //可以修改sql列名的别名与set方法一致
    private String name2;
    private Double price;

    public MultiTableBean(){}

    public MultiTableBean(Integer id, String billId, Integer menuId, Integer nums, Double money, Integer dinningTableId, Date billDate, String state, String name) {
        this.id = id;
        this.billId = billId;
        this.menuId = menuId;
        this.nums = nums;
        this.money = money;
        this.dinningTableId = dinningTableId;
        this.billDate = billDate;
        this.state = state;
        this.name2 = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getDinningTableId() {
        return dinningTableId;
    }

    public void setDinningTableId(Integer dinningTableId) {
        this.dinningTableId = dinningTableId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName1() {
        return name2;
    }

    public void setName1(String name) {
        this.name2 = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return String.format("\n%d\t%d\t%s\t%d\t%f\t%d\t%s\t%s\t%.2f", id, menuId, name2, nums, money, dinningTableId, billDate, state, price);
    }
}
