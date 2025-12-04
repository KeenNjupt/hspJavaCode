package com.keen.mhl.service;

import com.keen.mhl.dao.EmployeeDAO;
import com.keen.mhl.domain.Employee;

public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    //根据empId和pwd获取employee表记录，没有则返回null
    public Employee getEmployeeByempIdAndPwd(String empId, String pwd){
        return employeeDAO.querySingle("select * from employee where empId = ? and pwd = md5(?)", Employee.class, empId, pwd);
    }
}
