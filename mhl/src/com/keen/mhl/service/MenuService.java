package com.keen.mhl.service;

import com.keen.mhl.dao.MenuDAO;
import com.keen.mhl.domain.Menu;

import java.util.List;

public class MenuService {

    MenuDAO menuDAO = new MenuDAO();

    public List<Menu> listMenu(){
        return menuDAO.queryMulti("select * from menu", Menu.class);
    }
    public Menu getMenuById(Integer id){
        return menuDAO.querySingle("select * from menu where id = ?", Menu.class, id);
    }
}
