package com.muc.threaddemo;

public class ThreadDemo1 {
    public static void main(String[] args) {
        //打印出当前运行的主线程main名字
        String name = Thread.currentThread().getName();
        System.out.println(name);

    }


}
