package com.muc.blockarray;

import com.muc.producer_and_consumer.Desk;

import java.util.concurrent.ArrayBlockingQueue;

public class Cooker extends Thread{

    private ArrayBlockingQueue<String> list;
    public Cooker(ArrayBlockingQueue<String> list) {
        this.list = list;
    }


    @Override
    public void run() {


        while (true) {
            try {
               String take = list.take();//take()源码是加了锁的，但是我们的输出语句没有加锁，所以打印语句顺序不一定正确
               System.out.println("吃货从队列中获取了"+take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
