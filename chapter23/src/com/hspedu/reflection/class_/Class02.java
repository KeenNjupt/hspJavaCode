package com.hspedu.reflection.class_;

import com.hspedu.Car;

import java.lang.reflect.Field;

public class Class02 {
    public static void main(String[] args) throws Exception{
        String classPath = "com.hspedu.Car";
        //1.获取car类对象的Class对象
        Class<?> cls = Class.forName(classPath);
        //2.输出Class对象对应的类
        System.out.println(cls);
        //输出Class对象的类，java.lang.Class
        System.out.println(cls.getClass());
        //3. 得到包名
        System.out.println(cls.getPackage().getName());
        //4. 得到全类名
        System.out.println(cls.getName());
        //5. 获取类对应的对象
        Car car = (Car)cls.newInstance();
        System.out.println(car);
        //6. 获取对象对应的public字段
        Field brand = cls.getField("brand");
        String brandValue = (String) brand.get(car);
        System.out.println(brandValue);
        //7. 通过反射给对象赋值
        brand.set(car, "奔驰");
        System.out.println(car);
        //8. 遍历所有public字段
        Field[] fields = cls.getFields();
        for(Field f : fields){
            System.out.println(f.getType() + " " + f.getName() + " " + f.get(car));
        }
    }
}
