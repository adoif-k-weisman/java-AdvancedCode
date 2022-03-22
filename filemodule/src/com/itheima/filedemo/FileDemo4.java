package com.itheima.filedemo;

import java.io.File;

public class FileDemo4 {
    //注意点：
        //1.不走回收站的
        //2.如果删除的是文件，那么直接删除，如果删除的是文件夹，那么能删除空文件夹
        //3.如果要删除一个有内容的文件夹，只能向进入到这个文件夹，把里面的内容全部删除完毕，才能再次删除这个文件夹
    //简单来说：
        //只能删除文件和空文件夹.

    public static void main(String[] args) {
        //        File f1 = new File("E:\\itcast\\java.txt");
        //需求1：在当前模块目录下创建java.txt文件
        File f1 = new File("myFile\\java.txt");
        //        System.out.println(f1.createNewFile());

        //需求2：删除当前模块目录下的java.txt文件
        System.out.println(f1.delete());
        System.out.println("--------");

        //需求3：在当前模块目录下创建itcast目录
        File f2 = new File("myFile\\itcast");
        //        System.out.println(f2.mkdir());

        //需求4：删除当前模块目录下的itcast目录
        System.out.println(f2.delete());
        System.out.println("--------");

        //需求5：在当前模块下创建一个目录itcast,然后在该目录下创建一个文件java.txt
        File f3 = new File("myFile\\itcast");
        //        System.out.println(f3.mkdir());
        File f4 = new File("myFile\\itcast\\java.txt");
        //        System.out.println(f4.createNewFile());

        //需求6：删除当前模块下的目录itcast
        System.out.println(f4.delete());
        System.out.println(f3.delete());
    }
}
