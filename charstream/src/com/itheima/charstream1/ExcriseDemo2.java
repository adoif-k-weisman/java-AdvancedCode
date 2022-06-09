package com.itheima.charstream1;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;


//需求：读取文件中的数据，排序后再次写到本地文件
public class ExcriseDemo2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("charstream\\b.txt"));
//输出流不能写入到这里，因为会清空文件中的内容
//        BufferedWriter bw = new BufferedWriter(new FileWriter("charstream\\b.txt"));


        String line  = br.readLine();
        System.out.println("读取到的数据:"+line);
        br.close();
        //对读取到的字符进行切割
        String[] s = line.split(" ");
    //把字符数组转化成int数组
        int[] nums= new int[s.length];
        //遍历s数组进行数据转换
        for(int i=0;i<s.length;i++){
            int n = Integer.parseInt(s[i]);
            nums[i] = n;
        }

        Arrays.sort(nums);
        System.out.println("排序后的数据:"+Arrays.toString(nums));

        //写入结果
        BufferedWriter bw = new BufferedWriter(new FileWriter("charstream\\b.txt"));

        //写出
        for(int i=0;i<nums.length;i++){
            bw.write(nums[i]+" ");
            bw.flush();
        }
        bw.close();
    }
}
