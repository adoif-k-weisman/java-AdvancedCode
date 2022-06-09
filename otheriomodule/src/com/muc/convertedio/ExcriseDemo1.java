package com.muc.convertedio;

import java.io.*;

public class ExcriseDemo1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s1 = new Student("杜子腾",16);
        Student s2 = new Student("张三",23);
        Student s3 = new Student("李四",24);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));
        oos.writeObject(s1);
        oos.writeObject(s2);
        oos.writeObject(s3);

        oos.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
        Object obj;

        //对象流读到文件末尾没有结束标志,会抛出EOFException异常，对它处理即可
      /*  while((obj = ois.readObject()) != null){
            System.out.println(obj);
        }*/

       while(true){
           try {
               Object o = ois.readObject();
               System.out.println(o);
           } catch (EOFException e) {
               break;
           }
       }
        ois.close();
    }
}
