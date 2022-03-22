package com.ieheima.java_exception;

import java.util.Scanner;

public class ExceptionDemo10 {
    public static void main(String[] args) {
        //1.如果 try 中没有遇到问题，怎么执行？ --- 会把try中所有的代码全部执行完毕,不会执行catch里面的代码
        //2.如果 try 中遇到了问题，那么 try 下面的代码还会执行吗？
                            //那么直接跳转到对应的catch语句中,try下面的代码就不会再执行了
                            //当catch里面的语句全部执行完毕,表示整个体系全部执行完全,继续执行下面的代码
        //3.如果出现的问题没有被捕获，那么程序如何运行？
                             //那么try...catch就相当于没有写.那么也就是自己没有处理.
                             //默认交给虚拟机处理.
        //4.同时有可能出现多个异常怎么处理？
                            //出现多个异常,那么就写多个catch就可以了.
                            //注意点:如果多个异常之间存在子父类关系.那么父类一定要写在下面
                            //父类异常必然可以接受子类异常，那就没办法使用到子类异常了
        //Ctrl+alt+t: 使用各种语法结构

       // method1();

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你的年龄");
            String line = sc.nextLine();
            int age = Integer.parseInt(line);//格式化异常
            System.out.println(age);
            System.out.println(2 / 0); //数学异常
        } catch (Exception e) {
            //以后我们针对于每种不同的异常,有可能会有不同的处理结果.
        }
        System.out.println("测试456");


        //method();

        //method2();
    }

    private static void method1() {
        //自己没有处理到异常，还是默认交给虚拟机处理，就打印异常信息，停止程序运行
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你的年龄");
            String line = sc.nextLine();
            int age = Integer.parseInt(line);
            System.out.println(age);
            System.out.println("测试123");
        } catch (NullPointerException e) {
            System.out.println("看看执行了吗?");
        }
        System.out.println("测试456");
    }

    private static void method() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你的年龄");
            String line = sc.nextLine();
            int age = Integer.parseInt(line);
            System.out.println(age);
            System.out.println("测试123");
        } catch (NumberFormatException e) {
            System.out.println("看看执行了吗?");//输出了
        }
        System.out.println("测试456");//输出了
    }

    private static void method2() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你的年龄");
            String line = sc.nextLine();
            int age = Integer.parseInt(line);//格式化异常
            System.out.println(age);
            System.out.println(2 / 0); //数学异常
        } catch (NumberFormatException e) {
            System.out.println("格式化异常出现了");
        }catch (ArithmeticException e) {
            System.out.println("数学运算异常出现了");
        }
        System.out.println("测试456");
    }
}
