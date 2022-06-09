package com.muc.myvolatile;

public class Money {
    public static volatile int money = 100000; //如果不加 volatile 数据不会在多个线程之间及时共享
}
