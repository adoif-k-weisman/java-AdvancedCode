package com.muc.producer_and_consumer;

public class Demo {
    /*消费者步骤：
        1，判断桌子上是否有汉堡包。
        2，如果没有就等待。
        3，如果有就开吃
        4，吃完之后，桌子上的汉堡包就没有了
                叫醒等待的生产者继续生产
        汉堡包的总数量减一*/

        /*生产者步骤：
        1，判断桌子上是否有汉堡包
        如果有就等待，如果没有才生产。
        2，把汉堡包放在桌子上。
        3，叫醒等待的消费者开吃。*/

    public static void main(String[] args) {

        Desk desk = new Desk();
        Foodie foodie = new Foodie(desk);

        Cooker cooker = new Cooker(desk);

        foodie.start();
        cooker.start();

    }
}
