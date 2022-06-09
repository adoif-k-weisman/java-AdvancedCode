package com.muc.blockarray;

import com.muc.producer_and_consumer.Desk;

import java.util.concurrent.ArrayBlockingQueue;

public class Foodie extends Thread{

    private ArrayBlockingQueue<String> list;

    public Foodie(ArrayBlockingQueue<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
                list.put("汉堡包");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
