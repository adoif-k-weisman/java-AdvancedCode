package com.itheima.filedemo;

import java.io.File;
import java.io.IOException;

public class FileDemo3 {
    public static void main(String[] args) throws IOException {
        //method1();
        //method2();

        //public boolean mkdirs()    创建一个多级文件夹
                //注意点：
                    //1.可以创建单级文件夹，也可以创建多级文件夹
                    //2.不管调用者有没有后缀名，只能创建文件夹
        //疑问：
            //既然mkdirs能创建单级，也能创建多级，那么mkdir还有什么用啊？是的,真没有用
        File file=new File("D:\\IdeaProjects\\AdvancedCode\\filemodule\\aaa\\bbb\\ccc");
        boolean result=file.mkdirs();
        System.out.println(result);
    }

    private static void method2() {
        // public boolean mkdir()          创建单级文件夹
        //注意点：
        //1.只能创建单级文件夹，不能创建多级文件夹
        //2.不管调用者有没有后缀名，只能创建单级文件夹
        File file=new File("D:\\IdeaProjects\\AdvancedCode\\filemodule\\bbb\\ccc");
        boolean result=file.mkdir();
        System.out.println(result);
    }

    private static void method1() throws IOException {
        //public boolean createNewFile() 创建一个新的空文件
        //注意点：
        //1.如果文件存在，那么创建失败，返回false
        //2.如果文件不存在，那么创建成功，返回true
        //3.createNewFile方法不管调用者有没有后缀名，只能创建文件
        // File file1=new File("D:\\IdeaProjects\\AdvancedCode\\filemodule\\a.txt");
        File file1=new File("D:\\IdeaProjects\\AdvancedCode\\filemodule\\aaa");

        boolean result1=file1.createNewFile();
        System.out.println(result1);
    }
}
