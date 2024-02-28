package com.keen.map_;

import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        /* Properties继承了Hashtable类
        class Properties extends Hashtable<Object,Object>
         */
        Properties properties = new Properties();
        properties.put("1","one");
        properties.put("2","two");
        properties.put("3","three");

        System.out.println(properties);
        //delete
        properties.remove("3");
        System.out.println(properties);
        //update
        properties.put("1","I");
        System.out.println(properties);
        //select
        System.out.println(properties.get("1"));
        System.out.println(properties.getProperty("1"));
    }
}
