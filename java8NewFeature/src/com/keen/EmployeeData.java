package com.keen;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    public static List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<>();

        list.add(new Employee("keen",1,15));
        list.add(new Employee("marry",2,18));
        list.add(new Employee("a",2,19));
        return list;
    }
}
