package com.itheima.exercise;


import java.io.File;
import java.io.IOException;

public class Test1 {
    public static void main(String[] args) throws IOException {
        //练习一：在当前模块下的aaa文件夹中创建一个a.txt文件
       /* File file = new File("filemodule\\aaa\\a.txt");
        file.createNewFile();*/
        //注意点:文件所在的文件夹必须要存在.

        File file = new File("filemodule\\aaa");
        if(!file.exists()){
            //如果文件夹不存在,就创建出来
            file.mkdirs();
        }
        File newFile = new File(file,"a.txt");
        newFile.createNewFile();
    }
}
