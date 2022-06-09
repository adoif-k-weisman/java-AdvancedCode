package com.itheima.charstream1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamDemo4 {
    public static void main(String[] args) throws IOException {
    //    method1();

        method2();

        //创建对象
        FileReader fr1 = new FileReader("charstream\\a.txt");
        //创建一个数组
        char[] chars = new char[1024];
        int len;
        //一次性读取多个字符
        //read方法还是读取，但是是一次读取多个字符
        //他把读到的字符都存入到chars数组
        //返回值:表示本次读到了多少个字符

        while ((len= fr1.read(chars))!=-1){
            System.out.println(new String(chars,0,len));//这个len是很有必要的,非常标准
        }


        fr1.close();

    }

    //一次读取一个字符
    private static void method2() throws IOException {
        //创建字符输入流的对象
        FileReader fr = new FileReader(new File("charstream\\a.txt"));
        FileReader fr1 = new FileReader("charstream\\a.txt");

        //读取数据
        //一次读取一个字符
        int ch;
        while ((ch=fr.read())!=-1){
            System.out.println((char)ch);
        }
    }

    //flush --- close
    private static void method1() throws IOException {
        //flush()刷新流。刷新完毕之后，还可以继续写数据
        //close()关闭流。释放资源。一旦关闭，就不能写数据

        FileWriter fw  =new FileWriter("charstream\\a.txt");

        fw.write("黑马程序员");
        fw.flush();//使用刷新，将数据刷新到本地文件，可以在文件流还未关闭时，看到已经写入的内容
        fw.write("666");
        fw.flush();

        //在关闭之前，实际也会执行一次刷新操作.
        fw.close();
    }
}
