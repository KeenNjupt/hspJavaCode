package com.hspedu.houserent.view;
import com.hspedu.houserent.domain.House;
import com.hspedu.houserent.service.HouseService;
import com.hspedu.houserent.utils.Utility;

public class HouseView {
    //主菜单显示
    //显示房屋出租系统界面，接收用户输入
    //根据输入选项，调用service包中的各项功能
    //调用功能后，返回该界面
    // 若遇到退出功能，且用户输入的是退出选项，则退出系统；
    //否则继续显示界面
    //代码实现逻辑：循环显示界面，当用户输入退出时，改变循环控制变量，退出循环
    private boolean loop = true;
    private char selection;
    private HouseService houseService = new HouseService(2);
    public void mainMenu(){

        do{
            System.out.println("---------------房屋出租系统---------------");
            System.out.println("\t\t1 新增房源");
            System.out.println("\t\t2 查找房屋");
            System.out.println("\t\t3 删除房屋");
            System.out.println("\t\t4 修改房屋信息");
            System.out.println("\t\t5 房屋列表");
            System.out.println("\t\t6 退出");
            System.out.print("请输入你的选择(1-6): ");
            selection = Utility.readMenuSelection();
            switch (selection){
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    loop = !exit();
                    if(!loop) System.out.println("--------------退出系统--------------");
                    else System.out.println("--------------不退出系统--------------");
                    break;
                default:
                    break;
            }


        }while(loop);
    }
    //显示房屋列表信息
    public void listHouse(){
        House[] list = houseService.list();//调用HouseService类中的list方法得到房屋列表数据
        System.out.println("----------------房屋列表----------------");
        System.out.println("编号\t房主\t电话\t地址\t月租\t状态(未出租/已出租)");
        int listEnd = houseService.getListEnd();
        for(int i = 0; i < listEnd; ++i) {
            System.out.println(list[i]);
        }
        System.out.println("----------------房屋列表显示完毕----------------");

    }

    //添加房源信息
    public void addHouse(){//房屋编号为程序设计的自增值，不可由用户指定
        boolean res = false;
        System.out.println("--------------添加房屋--------------");
//        if(houseService.isFull()) System.out.println("存储已满，无法添加");
//        else {
        System.out.print("姓名: ");
        String name = Utility.readString(5);
        System.out.print("电话: ");
        String phone = Utility.readString(11);
        System.out.print("地址: ");
        String address = Utility.readString(10);
        System.out.print("月租: ");
        int rent = Utility.readInt();
        System.out.print("状态(已出租/未出租): ");
        String state = Utility.readState();
        House newHouse = new House(0, name, phone, address, rent, state);
        res = houseService.add(newHouse);
//        }
        if(res) System.out.println("--------------添加房屋成功--------------");
        else System.out.println("--------------添加房屋失败--------------");
    }
    //删除房源信息
    public void deleteHouse(){
        System.out.println("--------------删除房屋--------------");
        System.out.print("请选择待删除房屋编号(-1退出): ");
        int id = Utility.readInt();
        if(id == -1) {
            System.out.println("--------------放弃删除房屋信息--------------");
            return;
        }
        else{
            System.out.print("确认是否删除(Y/N): ");
            char c = Utility.readConfirmSelection();
            if(c == 'N') {
                System.out.println("--------------放弃删除房屋信息--------------");
                return;
            }
            else{
                boolean res = houseService.del(id);
                if(res) System.out.println("--------------删除完成--------------");
                else System.out.println("--------------删除失败：房屋不存在--------------");
            }
        }

    }
    /**
     * 退出系统
     */
    public boolean exit(){
        System.out.println("确实是否退出, ");
        char c = Utility.readConfirmSelection();
        return c == 'Y';
    }
    /**
     * 查找房屋
     */
    public void findHouse(){
        System.out.println("-----------查找房屋-----------");
        System.out.print("请输入查找的房屋编号: ");
        int id = Utility.readInt();
        House house = houseService.find(id);
        if(house == null) System.out.println("-----------房屋不存在-----------");
        else {
            System.out.println("编号\t房主\t电话\t地址\t月租\t状态(未出租/已出租)");
            System.out.println(house);
        }
        System.out.println("-----------查找完成-----------");
    }
    /**
     * 修改房屋
     */
    public void updateHouse(){
        System.out.println("---------------修改房屋---------------");
        System.out.print("请输入修改的房屋编号(-1退出): ");
        int id = Utility.readInt();
        if(id == -1) System.out.println("---------------退出修改房屋---------------");
        else{
            House house = houseService.find(id);
            if(house == null){
                System.out.println("房屋不存在");
            }
            else{
                System.out.print("姓名(" + house.getName() + "): ");
                String name = Utility.readString(10,house.getName());
                if(!name.equals(house.getName())) house.setName(name);
                System.out.print("电话(" + house.getPhone() + "): ");
                String phone = Utility.readString(10,house.getPhone());
                if(!phone.equals(house.getPhone())) house.setPhone(phone);
                System.out.print("地址(" + house.getAddress() + "): ");
                String address = Utility.readString(10,house.getAddress());
                if(!address.equals(house.getAddress())) house.setAddress(address);
                System.out.print("租金(" + house.getRent() + "): ");
                int rent = Utility.readInt(house.getRent());
                if(rent != house.getRent()) house.setRent(rent);
                System.out.print("状态(" + house.getState() + "): ");
                String state = Utility.readState(house.getState());
                if(!state.equals(house.getState())) house.setState(state);
                System.out.println("---------------修改完成---------------");
            }

        }

    }
}
