package com.muc.blockarray;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

    //    method();
        //创建阻塞队列的对象，容量为1
        ArrayBlockingQueue<String> list = new ArrayBlockingQueue<>(1);

        //创建线程并开启

        Cooker c = new Cooker(list);
        Foodie f = new Foodie(list);


        c.start();
        f.start();
    }


    //阻塞队列的基本用法
    private static void method() throws InterruptedException {
        //创建阻塞队列的对象，容量为1
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(1);

        //put and take 方法底层是有锁的

        //存储元素
        arrayBlockingQueue.put("汉堡包");
        //取元素
        System.out.println(arrayBlockingQueue.take());
    }
}
