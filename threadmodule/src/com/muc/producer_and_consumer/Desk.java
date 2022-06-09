package com.muc.producer_and_consumer;

public class Desk {

    //定义一个标记
    //true 就表示桌子上有汉堡的，此时允许吃货执行
    //false 就表示桌子上没有汉堡的，此时允许厨师执行
   // public static boolean flag = false;
    //优化成更加面向对象
    private boolean flag;

    //汉堡包的总数量
    //public static int count = 10;
    //以后在使用这种必须有默认值的变量,不要忘了赋值
    private int count = 10;

    //锁对象  使用final ,不允许修改
    // public static final Object lock = new Object();

    private final Object lock = new Object();

    public Desk() {
    }

    public Desk(boolean flag, int count) {
        this.flag = flag;
        this.count = count;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "Desk{" +
                "flag=" + flag +
                ", count=" + count +
                ", lock=" + lock +
                '}';
    }
}
