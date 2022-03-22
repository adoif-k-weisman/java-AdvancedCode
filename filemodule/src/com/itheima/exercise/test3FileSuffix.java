package com.itheima.exercise;

import javax.print.DocFlavor;
import java.io.File;
import java.util.HashMap;

public class test3FileSuffix {
    public static void main(String[] args) {
        //统计一个文件夹中，每种文件出现的次数
        //统计 --- 定义一个变量用来统计。 --- 弊端：同时只能统计一种文件
        //利用map集合进行数组统计 ， 键 --- 文件后缀名  值 --- 次数
        File file = new File("filemodule");
        HashMap<String, Integer> hm = new HashMap<>();
        getCount(hm,file);
    }

    private static void getCount(HashMap<String, Integer> hm, File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if(f.isFile()){
                String fName = f.getName();//得到文件名字
                //正则表达式，'.'是特殊符号，要想使用必须加个转义符，可是转义符也是特殊符号，只能再加一个转义符。
                String[] fNameArr = fName.split("\\.");
                //缺陷：aaaa   aaa.txt.txt 这类文件是无法统计的

                if(fNameArr.length==2){//aaa.后缀名  普通情况
                    String fileEndName=fNameArr[1];
                    if(hm.containsKey(fileEndName)){
                        //已经存在
                        //将已经出现的次数获取出来(hashMap不支持下标访问)
                        Integer count = hm.get(fileEndName);
                        //这种文件又出现了一次。
                        count++;
                        //把已经出现的次数给覆盖掉
                        hm.put(fileEndName,count);

                    }else{
                        //不存在
                        //表示当前文件是第一次出现
                        hm.put(fileEndName,1);
                    }
                }
            }else {
                //递归进入
                getCount(hm,f);
            }

        }
    }
}
