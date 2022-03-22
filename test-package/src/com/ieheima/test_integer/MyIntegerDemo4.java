package com.ieheima.test_integer;

public class MyIntegerDemo4 {
    public static void main(String[] args) {
        String s1 = "100";
        int i1 = 200;
        System.out.println(s1 + i1);//100200 --- 字符串+任意的数据类型 结果都是一个字符串

        int i2 = Integer.parseInt(s1);//可以将字符串类型的整数变成int类型的整数
        System.out.println(i2 + i1);


        //int  ---> String
        //方式一: +""
        int i3 = 100;
        String s2 = i3 + "";
        System.out.println(s2 + 100);

        //方式二: 可以调用String类中valueof方法
        String s3 = String.valueOf(i3);
        System.out.println(s3 + 100);
    }
}
