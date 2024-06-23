package com.keen.file;

import org.junit.jupiter.api.Test;

import java.io.File;

public class DirectoryTest {
    public static void main(String[] args) {

    }

    @Test
    void deleteFileAndDir(){
//        File file = new File("E:\\javafile2.txt");
        File file = new File("E:\\javaDir");
        if(file.exists()){
            if(file.delete()){ //删除文件或者空目录，删除非空目录返回false
                System.out.println(file.getAbsolutePath() + "删除成功");
            }
            else{
                System.out.println(file.getAbsolutePath() + "删除失败");
            }
        }

    }

    @Test
    void createDir(){
        File file = new File("E:\\javaDirTest\\a\\b\\c");
        if(!file.exists()){
            if(file.mkdir()){
                System.out.println("生成一级目录成功" + file.getAbsolutePath());
                return;
            }
            else{
                System.out.println("生成一级目录失败" + file.getAbsolutePath());
            }
            if(file.mkdirs()){
                System.out.println("生成多级目录成功" + file.getAbsolutePath());
            }
            else{
                System.out.println("生成多级目录失败" + file.getAbsolutePath());
            }
        }
    }
}
