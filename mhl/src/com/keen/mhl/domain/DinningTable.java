package com.keen.mhl.domain;

//create table dinningTable(
//        id INT PRIMARY KEY AUTO_INCREMENT,
//        state varchar(20) NOT NULL DEFAULT '',
//        orderName varchar(50) NOT NULL DEFAULT '',
//        orderTel varchar(20) NOT NULL DEFAULT ''
//        );
public class DinningTable {
    Integer id;
    String state;
    String orderName;
    String orderTel;
    public DinningTable(){}

    public DinningTable(Integer id, String state, String orderName, String orderTel) {
        this.id = id;
        this.state = state;
        this.orderName = orderName;
        this.orderTel = orderTel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderTel() {
        return orderTel;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }

    @Override
    public String toString() {
        return id + "\t\t\t" + state;
    }
}
