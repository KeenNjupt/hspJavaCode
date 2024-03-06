package com.keen.generic_;

import org.junit.jupiter.api.Test;

import java.util.*;

public class GenericHomework {
    public static void main(String[] args) {

    }

    @Test
    public void test(){
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1",new User(1,1,"aa"));
        userDAO.save("2",new User(2,1,"bb"));
        userDAO.save("3",new User(3,1,"cc"));

        List<User> list = userDAO.list();
        System.out.println(list);

        userDAO.update("3",new User(3,1,"dd"));
        System.out.println("修改后");
        System.out.println(userDAO.list());

        userDAO.delete("1");
        System.out.println("修改后");
        System.out.println(userDAO.list());

    }
}

class DAO<T>{
    private Map<String, T> m = new HashMap<>();

    public void save(String id, T entity){
        m.put(id,entity);
    }
    public T get(String id){
        return m.get(id);
    }
    public void update(String id, T entity){
        m.put(id, entity);
    }
    public List<T> list(){
//        return (List<T>) m.values();
        List<T> ts = new ArrayList<>();
        Collection<T> values = m.values();
        for(T i: values){
            ts.add(i);
        }
        return ts;
    }

    public void delete(String id){
        m.remove(id);
    }

}

class User{
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
