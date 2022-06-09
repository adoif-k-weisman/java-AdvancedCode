package com.itheima.charstream1;

import java.io.*;
//字符缓冲流 输入流、输出流
public class CharStreamDemo5 {
    public static void main(String[] args) throws IOException {

        //method1();

        //method2();

      //  method3();

        //字符缓冲输入流
        BufferedReader br = new BufferedReader(new FileReader("charstream\\a.txt"));

        //读取数据
        /*
        String line1 = br.readLine();
        String line2 = br.readLine();
        String line3 = br.readLine();
        String line4 = br.readLine();
        String line5 = br.readLine();*/

        //在之前。如果读不到数据，返回-1
        //但是readLine 如果读不到数据返回null
        //注意使用时的循环条件
        /*
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
        System.out.println(line5);*/


        //使用循环改进
        String line;
        //可以读取一整行数据、读到回车换行符为止，但不会读入回车换行符
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
        br.close();

    }

    private static void method3() throws IOException {
        //创建对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("charstream\\a.txt"));

        //写出数据
        bw.write("shiina樱花");
        //跨平台的回车换行    会自动为你识别系统、并写入换行符
        //字符缓冲输入流的特别功能
        bw.newLine();

        bw.write("abcdef");
        bw.newLine();

        bw.close();
    }

    private static void method2() throws IOException {
        //字符缓冲输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("charstream\\a.txt"));

        //写出数据
        //实际写出的是97对应的字符a
        bw.write(97);
        bw.write("\r\n");

        //实际写出的是97 - 101 对应的字符 abcde
        char [] chars = {97,98,99,100,101};
        bw.write(chars);
        bw.write("\r\n");

        //实际写的是abc
        bw.write(chars,0,3);
        bw.write("\r\n");

        //会把字符串的内容原样写出
        bw.write("黑马程序员");
        bw.write("\r\n");

        //会把字符串的一部分写出 abcde
        String line = "abcdefg";
        bw.write(line,0,5);

        bw.flush();

        bw.close();
    }

    private static void method1() throws IOException {
        //字符缓冲输入流
        BufferedReader br = new BufferedReader(new FileReader("charstream\\a.txt"));

        //读取数据
        char[] chars = new char[1024];
        int len;
        while( (len=br.read(chars))!=-1){
            System.out.println(new String(chars,0,len));
        }

        br.close();
    }

}
