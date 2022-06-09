package com.muc.convertedio;

import java.io.*;
import java.util.ArrayList;

//用一个集合把所有的对象存入，最后将集合写入文件，那么读取就只需要读取一个集合，不需要判断结束标志了
public class ExcriseDemo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s1 = new Student("杜子腾",16);
        Student s2 = new Student("张三",23);
        Student s3 = new Student("李四",24);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));
        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        //我们往本地文件中写的就是一个集合
        oos.writeObject(list);

        oos.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
        //进行强转
        ArrayList<Student> list2 = (ArrayList<Student>) ois.readObject();
        for (Student student : list2) {
            System.out.println(student);
        }
        ois.close();
    }
}
