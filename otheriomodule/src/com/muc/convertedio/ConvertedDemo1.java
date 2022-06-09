package com.muc.convertedio;

import java.io.*;
import java.nio.charset.Charset;

public class ConvertedDemo1 {
    public static void main(String[] args) throws IOException {


      //  method1();
       // method2();

        //在JDK11之后，字符流推出了一个构造，也可以指定编码表
        FileReader fr = new FileReader("C:\\Users\\adoif\\Desktop\\test.txt", Charset.forName("gbk"));

        int ch;
        while((ch=fr.read())!=-1){
            System.out.println((char) ch);
        }

        fr.close();


    }

    private static void method2() throws IOException {
        //如何解决乱码?
        //那么：文件是什么码表，我们就用什么码表去读取
        //我们就要指定使用GBK码表去读取文件
        InputStreamReader isr = new InputStreamReader(new FileInputStream("C:\\Users\\adoif\\Desktop\\test.txt"),"GBK");
        //指定编码格式：GBK gbk 大小写都是没问题的

        int ch;
        while ((ch = isr.read())!=-1){
            System.out.println((char)ch);// 我这里肯定会出现乱码，因为是gbk格式
        }

        isr.close();


        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("C:\\Users\\adoif\\Desktop\\test.txt"),"GBK");
        osw.write("无论世界多么崩坏，我都只想再见到她的笑颜");

        osw.close();
    }

    // //这个方法直接读取会产生乱码
    //    //因为文件是GBK码表
    //    //而idea默认的是UTF-8编码格式.
    //    //所以两者不一致,导致乱码

    //当然，我这里读取是不会乱码的，因为我电脑文本文件格式已经更改为默认UTF-8，如果是ANSI的话，windows下是GBK编码
    private static void method1() throws IOException {
        FileReader fr = new FileReader("C:\\Users\\adoif\\Desktop\\test.txt");
        int ch;
        while((ch=fr.read())!=-1){
            System.out.println((char) ch);
        }

        fr.close();
    }
}
