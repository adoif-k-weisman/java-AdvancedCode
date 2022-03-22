package com.itheima.filedemo;

import java.io.File;

public class FileDemo1 {
    public static void main(String[] args) {
        //File(String pathname): 通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例
        File f1 = new File("E:\\itcast\\java.txt");
        System.out.println(f1);

        //File(String parent, String child): 从父路径名字符串和子路径名字符串创建新的 File实例
        File f2 = new File("E:\\itcast","java.txt");
        System.out.println(f2);

        //File(File parent, String child): 从父抽象路径名和子路径名字符串创建新的 File实例
        File f3 = new File("E:\\itcast");
        File f4 = new File(f3,"java.txt");
        System.out.println(f4);
    }
}
