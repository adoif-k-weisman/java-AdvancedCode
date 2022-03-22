package com.ieheima.test_math;

public class MathDemo {
    public static void main(String[] args) {
        //public static double ceil(double a)  //向上取整
        double ceil=Math.ceil(10.1);
        System.out.println(ceil);
        //public static double floor(double a) 向下取整
        double floor=Math.floor(10.1);
        System.out.println(floor);

        //public static int round(float a) 四舍五入
        long round = Math.round(10.5);
        System.out.println(round);

        //public static double random()  返回值为double的正值，[0.0,1.0)
        for (int i=0;i<10;i++) {
            double random = Math.random();
            System.out.println(random);
        }
        //ctrl + alt +t --->
    }
}
