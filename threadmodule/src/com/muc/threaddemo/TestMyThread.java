package com.muc.threaddemo;

public class TestMyThread {

    //线程是有默认名字的，格式：Thread-编号
    public static void main(String[] args) throws InterruptedException {
        //创建一个线程对象
        MyThread t1 = new MyThread("adoif");
        //创建一个线程对象
        MyThread t2 = new MyThread("sakura");

        /*//给线程设置名字  1.使用setName  2. 构造方法使用
        t1.setName("adoif");
        t2.setName("sakura");*/

        //t1.run();//表示的仅仅是创建对象,用对象去调用方法,并没有开启线程.
        //t2.run();
        //开启一条线程
        t1.start();
        //开启第二条线程
        t2.start();

        System.out.println("睡觉前:");
        Thread.sleep(3000);
        System.out.println("睡觉了");
    }
}
