package com.keen.mhl.view;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.keen.mhl.domain.*;
import com.keen.mhl.service.BillService;
import com.keen.mhl.service.DinningTableService;
import com.keen.mhl.service.EmployeeService;
import com.keen.mhl.service.MenuService;
import com.keen.mhl.utils.Utility;

import java.util.List;

public class MHLView {
    //控制主页面是否继续显示
    private static boolean loop = true;
    private static String key = "";
    EmployeeService employeeService = new EmployeeService();
    DinningTableService dinningTableService = new DinningTableService();
    MenuService menuService = new MenuService();
    BillService billService = new BillService();

    public static void main(String[] args) {
        MHLView mhlView = new MHLView();
        mhlView.mainMenu();
    }
    public void listTable(){

        System.out.println("\n餐桌编号\t\t餐桌状态");
        List<DinningTable> list = dinningTableService.list();
        for(DinningTable table : list){
            System.out.println(table);
        }
        System.out.println("显示餐桌状态完成");
    }
    public void orderDinningTable(){
        System.out.println("========预定餐桌========");
        System.out.println("请输入餐桌编号(-1表示退出预定):");
        int id = Utility.readInt();
        if( id == -1){
            System.out.println("退出预定");
        }
        else{
            System.out.println("请输入预定人姓名:");
            String orderName = Utility.readString(50);
            System.out.println("请输入预定人电话:");
            String orderTel = Utility.readString(50);
            char c = Utility.readConfirmSelection();
            if(c == 'Y') {
                DinningTable dinningTableById = dinningTableService.getDinningTableById(id);
                if (dinningTableById == null) {
                    System.out.println("餐桌编号不存在！");
                } else {
                    if ("空".equals(dinningTableById.getState())) {
                        boolean b = dinningTableService.orderDinningTable(id, orderName, orderTel);
                        if(b){
                            System.out.println("预定成功");
                        }
                        else{
                            System.out.println("预定失败");
                        }
                    }
                    else {
                        System.out.println(id + " 已经被预定了");
                    }
                }
            }
            else{
                System.out.println("取消预定");
            }
        }
    }
    public void listMenu(){
        List<Menu> menus = menuService.listMenu();
        System.out.println(String.format("菜品编号\t菜品名\t类别\t价格"));
        for(Menu menu : menus){
            System.out.println(menu);
        }
    }
    public void orderMenu(){
        System.out.println("======点餐服务======");
        System.out.println("请输入点餐的桌号(-1退出):");
        int orderDinningTableId = Utility.readInt();
        if(orderDinningTableId == -1){
            System.out.println("======取消点餐======");
            return;
        }
        System.out.println("请输入点餐的菜品号(-1退出):");
        int orderMenuId = Utility.readInt();
        if(orderMenuId == -1){
            System.out.println("======取消点餐======");
            return;
        }
        System.out.println("请输入点餐的菜品量(-1退出):");
        int orderNums = Utility.readInt();
        if(orderNums == -1){
            System.out.println("======取消点餐======");
            return;
        }
        //验证餐桌号是否可用
        DinningTable dinningTableById = dinningTableService.getDinningTableById(orderDinningTableId);
        if( dinningTableById == null || !(dinningTableById.getState().equals("空")) ){
            System.out.println("=====餐桌号不存在=====");
            return;
        }
        //验证菜品号是否存在
        Menu menuById = menuService.getMenuById(orderMenuId);
        if( menuById == null ){
            System.out.println("======菜品号不存在======");
            return;
        }

        //点餐
        Boolean b = billService.orderMenu(orderMenuId, orderNums, orderDinningTableId);
        if(!b){
            System.out.println("======点餐失败======");
        }
        else{
            System.out.println("======点餐成功======");
        }
    }

    public void listBill(){
        System.out.println(String.format("\n编号\t菜品号\t菜品量\t金额\t桌号\t日期\t状态"));
        List<Bill> bills = billService.listBill();
        for(Bill bill : bills){
            System.out.println(bill);
        }
    }

    public void listBillMulti(){
        System.out.println(String.format("\n编号\t菜品号\t菜品名\t菜品量\t金额\t桌号\t日期\t状态\t价格"));
        List<MultiTableBean> multiTableBeans = billService.listBillMulti();
        for(MultiTableBean bill : multiTableBeans){
            System.out.println(bill);
        }
    }

    public void checkout(){
        System.out.println("======结账服务======");
        System.out.println("请选择要结账的餐桌编号(-1退出):");
        int dinningTableId = Utility.readInt();
        if(dinningTableId == -1){
            System.out.println("=====退出结账=====");
            return;
        }

        System.out.println("结账的方式(现金/支付宝/微信)回车表示退出:");
        String billState = Utility.readString(3);
        if(billState == ""){
            System.out.println("=====退出结账=====");
            return;
        }

        System.out.println("确认是否结账(Y/N):");
        String selection = Utility.readString(1).toUpperCase();
        if(selection.equals("N")){
            System.out.println("=====退出结账=====");
            return;
        }

        DinningTable dinningTableById = dinningTableService.getDinningTableById(dinningTableId);
        boolean billExist = billService.checkBillByDinningTableId(dinningTableId);
        if( dinningTableById == null ){
            System.out.println("=====餐桌编号不存在====");
            return;
        }
        else if(!billExist){
            System.out.println("=====餐桌没有待结账的账单=====");
        }
        else{
            //更新bill状态
            Boolean b = billService.checkoutBill(dinningTableId, billState);
            if(b){
                System.out.println("=====结账成功=====");
            }
            else{
                System.out.println("=====结账失败=====");
            }
        }
    }


    public void mainMenu() {
        while (loop){
            System.out.println("=============满汉楼=============");
            System.out.println("\t\t1 登录满汉楼");
            System.out.println("\t\t2 退出满汉楼");
            System.out.println("请输入你的选择:");
            key = Utility.readString(1);
            switch(key){
                case "1":
                    System.out.println("请输入员工号：");
                    String empId = Utility.readString(50);
                    System.out.println("请输入密 码：");
                    String pwd = Utility.readString(50);
                    //密码和用户需要查询数据库进行验证
                    Employee employeeByempIdAndPwd = employeeService.getEmployeeByempIdAndPwd(empId, pwd);
                    if(employeeByempIdAndPwd != null ){
                        //登录成功，进入二级菜单
                        System.out.println(String.format("==========[%s]登录成功==========", employeeByempIdAndPwd.getName()));
                        while(loop) {
                            System.out.println("=============满汉楼(二级菜单)=============");
                            System.out.println("\t\t1 显示餐桌状态");
                            System.out.println("\t\t2 预定餐桌");
                            System.out.println("\t\t3 显示所有菜品");
                            System.out.println("\t\t4 点餐服务");
                            System.out.println("\t\t5 查看账单");
                            System.out.println("\t\t6 结账");
                            System.out.println("\t\t9 退出满汉楼");
                            System.out.println("请输入你的选择:");
                            key = Utility.readString(1);
                            switch (key){
                                case "1":
                                    listTable();
                                    break;
                                case "2":
//                                    System.out.println("预定餐桌");
                                    orderDinningTable();
                                    break;
                                case "3":
//                                    System.out.println("显示所有菜品");
                                    listMenu();
                                    break;
                                case "4":
//                                    System.out.println("点餐服务");
                                    orderMenu();
                                    break;
                                case "5":
//                                    System.out.println("查看账单");
//                                    listBill();
                                    listBillMulti();
                                    break;
                                case "6":
//                                    System.out.println("结账");
                                    checkout();
                                    break;
                                case "9":
                                    loop = false;
                                    break;
                                default:
                                    System.out.println("输入有误，请重新输入：");
                                    break;

                            }
                        }
                    }
                    else{
                        System.out.println("密码错误，请重新登录");
                    }
                    break;
                case "2":
                    loop = false;
                    break;
                default:
                    System.out.println("输入有误请重新输入");
                    break;
            }
        }
        System.out.println("退出了满汉楼系统");
    }
}
