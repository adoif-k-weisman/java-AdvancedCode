package com.itheima.exercise;

import java.io.File;

public class test2 {
    public static void main(String[] args) {
        File file = new File("D:\\实验文件夹(东西随便放,随便删除)");
        myAnsForDelFile(file);

        //改进方法为递归
        deleteDir(file);
    }

    private static void deleteDir(File file) {
        //先删掉这个文件夹里面所有的内容.
        //递归 方法在方法体中自己调用自己.
        //注意: 可以解决所有文件夹和递归相结合的题目
        //1.进入 --- 得到实验文件夹里面所有内容的File对象.
        File[] path = file.listFiles();
        //2.遍历  ---- 因为我想得到该文件夹里面每一个文件和文件夹的File对象
        for (File file1 : path) {
            if(file1.isFile()){
                //3.判断 --- 如果遍历到的File对象是一个文件，那么直接删除。
                file1.delete();
            }else {
                //4.判断
                //递归
                deleteDir(file1);//参数一定要是文件夹里面的文件夹File对象
            }
        }
        file.delete();
    }

    private static void myAnsForDelFile(File file) {
        File[] file1= file.listFiles();
        if(file1==null){
            System.out.println("子目录为空，可以直接开始删除");
        }
        else{
            for (File path : file1) {
                if(path.isDirectory()){//进入了再删
                    File[] path_zi = path.listFiles();
                    //这里存在一个问题，这玩意你肯定不知道有多少子文件夹或者子文件
                    //肯定需要递归去解决
                }else if(path.isFile()){
                    path.delete();//直接删除
                }
            }
        }
        file.delete();
    }
}
