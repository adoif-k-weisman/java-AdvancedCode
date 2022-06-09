package com.muc.threaddemo7;

public class Demo {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        //参数mr只有一个，所以锁对象使用this 是没有问题的，
        // 不需要像Thread private static Object ob一样,那种使用多个Thread 对象
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);

        t1.setName("窗口一");
        t2.setName("窗口二");

        t1.start();
        t2.start();
    }
}
