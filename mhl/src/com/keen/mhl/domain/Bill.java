package com.keen.mhl.domain;



//create table bill(
//        id INT PRIMARY KEY AUTO_INCREMENT, -- 自增主键
//        billId varchar(50) NOT NULL DEFAULT '',-- 账单号 uuid
//        menuId int NOT NULL , -- 菜品编号
//        nums int NOT NULL , -- 数量
//        money double NOT NULL , -- 金额
//        dinningTableId int NOT NULL , -- 餐桌编号
//        billDate DATETIME NOT NULL , -- 账单日期
//        state varchar(50) NOT NULL DEFAULT '' -- 状态 未结账、已结账、挂单、现金、支付宝、坏账
//        );

import java.util.Date;

public class Bill {
    private Integer id;
    private String billId;
    private Integer menuId;
    private Integer nums;
    private Double money;
    private Integer dinningTableId;
    private Date billDate;
    private String state;

    public Bill() {
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

    @Override
    public String toString(){
        return String.format("\n%d\t%d\t%d\t%f\t%d\t%s\t%s", id, menuId, nums, money, dinningTableId, billDate, state);
    }
}
