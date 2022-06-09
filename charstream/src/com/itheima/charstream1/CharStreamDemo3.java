package com.itheima.charstream1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//字符流写数据
public class CharStreamDemo3 {
    public static void main(String[] args) throws IOException {

      //创建字符输出流的对象
       // FileWriter fw = new FileWriter(new File("charstream\\a.txt"));
        FileWriter fw2 = new FileWriter("charstream\\a.txt");//如果创建的文件是存在的，会清空原来的内容

        FileWriter fw3 = new FileWriter("charstream\\b.txt");// 文件不存在，会自动创建一个文件,前提：这个文件目录的父目录是存在的

        //FileWriter fw4 = new FileWriter("charstream\\shiina\\a.txt");//如果父目录不存在，会报错



    //写出数据
/*
        //写一个字符
        fw2.write(97);
        fw2.write(98);
        fw2.write(99);
*/
        /*//写一个字符数组
        char[] chars = {97,98,99,100,101};
        fw2.write(chars);*/

        /*//写入一个字符数组的一部分 第二个参数就是偏移量(开始地址)
        char[] chars = {97,98,99,100,101};
        fw2.write(chars,1,3);*/

        /*//void write(String str)     写一个字符串
        String line  = "黑马程序员abc";
        fw2.write(line);*/

        //void write(String str,int off,int len)  写一个字符串的一部分
        String line ="黑马程序员abc";
        fw2.write(line,1,2);


        //释放资源
        fw2.close();
        //fw2.write();

    }
}
