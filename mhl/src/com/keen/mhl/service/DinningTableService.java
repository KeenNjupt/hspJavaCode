package com.keen.mhl.service;

import com.keen.mhl.dao.DinningTableDAO;
import com.keen.mhl.domain.DinningTable;

import java.util.List;

public class DinningTableService {
    DinningTableDAO dinningTableDAO = new DinningTableDAO();

    public List<DinningTable> list(){
        return dinningTableDAO.queryMulti("select id, state from dinningTable", DinningTable.class);
    }
    //根据id查询餐桌对象
    public DinningTable getDinningTableById(int id){
        return dinningTableDAO.querySingle("select * from dinningTable where id = ?", DinningTable.class, id);
    }

    //预定餐桌
    public boolean orderDinningTable(int id, String orderName, String orderTel){
        int rows = dinningTableDAO.update("update dinningTable set state = '已经预定', orderName = ?, orderTel = ? where id = ?",  orderName, orderTel, id);
        return rows > 0;
    }

    //修改餐桌状态
    public boolean updateDinningTableState(int id, String state){
        int rowsDinningTable = dinningTableDAO.update("update dinningTable set state = ? where id = ? ", state, id);
        return rowsDinningTable > 0;
    }

    //将餐桌状态置空，清楚人员信息
    public boolean updateDinningTableToFree(int id){

        int rowsDinningTable = dinningTableDAO.update("update dinningTable set state = ? , orderName = '', orderTel = '' where id = ? ", "空", id);
        return rowsDinningTable > 0;
    }

}
