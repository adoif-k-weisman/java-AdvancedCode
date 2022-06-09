package com.muc.threaddemo6;

public class MyThread extends Thread {
    private static int ticketCount = 100;
    private static Object obj = new Object();

    @Override
    public void run() {
        while(true){
            synchronized (obj){ //就是当前的线程对象.  如此才能满足这个锁是对所有的线程有效的
            //synchronized (this)---如此写，就是错误的，因为该类被创建了二个对象，即使ticketCount是类公有的属性
                if(ticketCount <= 0){
                    //卖完了
                    break;
                }else{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticketCount--;
                    System.out.println(Thread.currentThread().getName() + "在卖票,还剩下" + ticketCount + "张票");
                }
            }
        }
    }
}
