package com.keen.String_;

public class StringExercise02 {
    public static void main(String[] args) {
        try {
            test("llll","123456","11@11.");
            System.out.println("注册成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        new Object().equals()
    }

    /**
     * 用户名长度为2-4
     * 密码长度为6且全是数字
     * 邮箱中包含@和.且@在.前面
     */
    public static void test(String userName, String password, String email){
        //判断用户名
        if(!(userName != null && userName.length() >= 2 && userName.length() <= 4)){
            throw new RuntimeException("用户名长度为2-4");
        }
        //判断密码
        if(!(password != null && password.length() == 6 && isDigital(password))){
            throw new RuntimeException("密码长度为6且全是数字");
        }
        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if(!(i != -1 && j != -1 && i < j)){
            throw new RuntimeException("邮箱中包含@和.且@在.前面");
        }
    }
    public static boolean isDigital(String s){
        if(s == null) return false;
        boolean res = true;
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                res = false;
                break;
            }
        }
        return res;
    }
}
