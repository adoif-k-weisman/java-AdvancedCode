package com.itheima.filedemo;

import java.io.File;

public class FileDemo6ListFile {
    public static void main(String[] args) {
        File file=new File("D:\\");
        File[] files=file.listFiles();//返回值是一个File类型的数组
        //如何快捷使用增强for,要遍历的数组名.for enter回车即可。
        for (File path : files) {
            System.out.println(path);
        }
        //进入文件夹，获取这个文件夹里面所有的文件和文件夹的File对象，并把这些File对象都放在一个数组中返回。
        //包括隐藏文件和隐藏文件夹都可以获取。


        //注意事项:
            //1.当调用者是一个文件时，         报错，数组为null
            //2,当调用者是一个空文件夹时        数组长度为0，不报错。
            //3.当调用者是一个有内容的文件夹时        如上，返回该文件夹下所有文件夹和文件
            //4.当调用者是一个有权限才能进入的文件夹时     打不开
    }
}
