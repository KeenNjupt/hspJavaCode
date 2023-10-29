package com.hspedu.houserent.service;

import com.hspedu.houserent.domain.House;

public class HouseService {

    //返回房屋列表信息
    //利用数组保存已增加的房屋信息
    private House houseList[];
    private int listSize; //数组大小
    private int listEnd; //数组中有效元素的右边界(不包含)
    private int id; //House对象的id值为自增值
    public HouseService(int size){
        this.listSize = size;
        houseList = new House[listSize];
        this.listEnd = 0;
        id = 0;
        houseList[listEnd++] = new House(++id,"kkk","123","上海市",10,"未出租");
    }
    //判断数组空间是否已满
    public boolean isFull(){
        return listEnd == listSize;
    }
    //房屋信息数组扩容
    public boolean arrayExpand(){
        House[] newList = new House[listSize*2];
        for(int i = 0; i < listEnd; ++i){
            newList[i] = houseList[i];
        }
        houseList = newList;
        return true;
    }
    //添加房屋
    public boolean add(House newHouse){
        if(isFull()) arrayExpand();
        newHouse.setId(++id);//重置房屋id
        houseList[listEnd++] = newHouse;
        return true;
    }

    /**
     * 查找房屋下标
     * @return 房屋在数组中的下标，-1表示不存在
     */
    public House find(int id){
        int index = findIndex(id);
        return index != -1 ? houseList[index] : null;
    }
    /**
     * 查找房屋下标
     * @return 房屋在数组中的下标，-1表示不存在
     */
    public int findIndex(int id){
        int index = -1;
        for (int i = 0; i < listEnd; i++) {
            if(houseList[i].getId() == id){
                index = i;
                break;
            }
        }
        return index;
    }


    /**
     * 删除房屋
    */
    public boolean del(int id){
        int index = findIndex(id);
        if(index < listEnd && index >= 0){
            for(int i = index+1 ; i < listEnd; ++i){
                houseList[i-1] = houseList[i];
            }
            houseList[--listEnd] = null;
            return true;
        }
        else return false;
    }
    public int getListSize() {
        return listSize;
    }

    public int getListEnd() {
        return listEnd;
    }

    //返回房屋信息数组
    public House[] list(){
        return houseList;
    }
}
