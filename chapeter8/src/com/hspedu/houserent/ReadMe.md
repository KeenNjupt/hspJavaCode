## 房屋出租系统设计
### HouseRentApp.java
1. 该类包含main函数，是整个项目的程序入口
2. 创建HouseView对象，并调用该对象显示主菜单

### HouseView.java类(界面层)
1. 显示界面
2. 接收用户输入
3. 调用HouseService类完成对房屋信息的各种操作

### HouseService.java类(业务层)
1. 响应HouseView的调用
2. 完成对房屋信息的各种操作(增删改查，create read update delete)

### House.java类(模型层/数据层 domain/model)
1. 一个House对象表示一个房屋信息

### Utility.java类，工具类
1. 获取用户的各种输入