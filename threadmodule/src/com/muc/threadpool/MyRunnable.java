package com.muc.threadpool;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "在执行了");
    }
}
