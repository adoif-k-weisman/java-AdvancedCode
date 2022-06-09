package com.muc.producer_and_consumer;

public class Foodie extends Thread{

    private  Desk desk;

    public Foodie(Desk desk) {
        this.desk = desk;
    }

    @Override
    public void run() {
        /*消费者步骤：
        1，判断桌子上是否有汉堡包。
        2，如果没有就等待。
        3，如果有就开吃
        4，吃完之后，桌子上的汉堡包就没有了
                叫醒等待的生产者继续生产
        汉堡包的总数量减一*/

        //套路:
            //1. while(true) 死循环
            //2. synchronized 锁 ，锁对象要唯一
            //3. 判断共享数据是否结束，结束
            //4. 判断共享数据是否结束，没有结束
        while (true){
            synchronized (desk.getLock()){//二个线程之间切换需要同一把锁才能正确执行
                if(desk.getCount()==0){//10个汉堡吃完
                    break;
                }else {
                    if(desk.isFlag()){//桌子上有汉堡包
                        //有
                        System.out.println("吃货在吃汉堡包");
                        desk.setFlag(false);
                        desk.getLock().notifyAll();//唤醒这把锁上所有等待的线程
                        desk.setCount(desk.getCount()-1);
                    }else{
                        //没有就等待
                        //!!!细节：使用什么对象当做锁，那么就必须用这个对象去调用等待和唤醒的方法
                        try {
                            desk.getLock().wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
