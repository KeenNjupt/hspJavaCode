package com.keen.mhl.service;

import com.keen.mhl.dao.BillDAO;
import com.keen.mhl.dao.MultiTableDAO;
import com.keen.mhl.domain.Bill;
import com.keen.mhl.domain.MultiTableBean;

import java.util.List;
import java.util.UUID;

public class BillService {
    BillDAO billDAO = new BillDAO();
    MultiTableDAO multiTableDAO = new MultiTableDAO();

    MenuService menuService = new MenuService();
    DinningTableService dinningTableService = new DinningTableService();

    //点餐的方法
    //1. 生成账单，将点餐内容记录到bill表中
    //2. 更新餐桌的状态
    public Boolean orderMenu(int menuId, int nums, int dinningTableId){

        //将点餐内容记录到bill表中
        //生成账单号
        UUID uuid = UUID.randomUUID();
        int rows = billDAO.update("insert into bill(id, billId, menuId, nums, money, dinningTableId, billDate, state) " +
                        "values(null,?,?,?,?,?,now(),'未结账')",
                uuid.toString(), menuId, nums, menuService.getMenuById(menuId).getPrice() * nums, dinningTableId);
        if(rows < 1){
            return null;
        }
        //更新餐桌状态
        boolean updateDinningTableState = dinningTableService.updateDinningTableState(dinningTableId, "就餐中");

        return updateDinningTableState;
    }

    public List<Bill> listBill(){
        return billDAO.queryMulti("select * from bill", Bill.class);
    }
    public List<MultiTableBean> listBillMulti(){
        return multiTableDAO.queryMulti("select bill.*, name as name1, price from bill, menu where bill.menuId = menu.id", MultiTableBean.class);
    }


    //查看该餐桌号是否待结账
    public boolean checkBillByDinningTableId(int dinningTableId){
        Bill bill = billDAO.querySingle("select * from bill where dinningTableId = ? and state = '未结账' limit 1", Bill.class, dinningTableId);
        return bill != null;
    }

    //结账
    //更新bill表状态
    //更新dinningTable表状态
    public Boolean checkoutBill(int dinningTableId, String state){
        //更新bill表
        int rows = billDAO.update("update bill set state = ? where dinningTableId = ? and state = '未结账'", state, dinningTableId);
        if(rows < 1){
            return false;
        }
        //更新餐桌状态，用dinningTableService方法去修改
        boolean updateDinningTableState = dinningTableService.updateDinningTableToFree(dinningTableId);
        return updateDinningTableState;

    }
}
