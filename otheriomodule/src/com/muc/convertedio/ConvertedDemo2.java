package com.muc.convertedio;

import java.io.*;

public class ConvertedDemo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //写对象 --- 序列化
        //method1();

        //读对象 -- 反序列化
        //method2();
    }

    private static void method2() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
        User o = (User)ois.readObject();
        System.out.println(o);

        ois.close();
    }

    private static void method1() throws IOException {
        User user = new User("adoif","qwer");

        //写出到文件中
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));

        oos.writeObject(user);
        oos.close();
    }
}
