package com.itheima.charstream1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Excrise {
    public static void main(String[] args) throws IOException {
        //将键盘录入的用户名和密码保存到本地实现永久化存储
        //要求：用户名独占一行，密码独占一行

        Scanner sc =new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = sc.next();
        System.out.println("请输入用户密码:");
        String passworld = sc.next();

        FileWriter fw = new FileWriter("charstream\\a.txt");
        fw.write(username);
        //表示写出一个回车换行符   windows \r\n  linux \n
        fw.write("\r\n");
        fw.write(passworld);

        fw.flush();
        fw.close();
    }
}
