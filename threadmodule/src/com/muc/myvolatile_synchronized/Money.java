package com.muc.myvolatile_synchronized;

public class Money {
    public static Object lock = new Object();//定义锁对象
    public static volatile int money = 100000;
}
