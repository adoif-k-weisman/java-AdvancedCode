package com.muc.threaddemo3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestMyCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //线程开启之后需要执行里面的call方法
        MyCallable mc = new MyCallable();
        MyCallable mc2 = new MyCallable();
        //可以获取线程执行完毕之后的结果、也可以作为参数传递给Thread对象
        FutureTask<String> ft = new FutureTask<>(mc);
        FutureTask<String> ft2 = new FutureTask<>(mc2);

        //创建线程对象
        Thread t1 = new Thread(ft);
        Thread t2 = new Thread(ft2);
        t1.setName("飞机");
        t2.setName("坦克");


        //线程优先级为1~~10  默认为5  数字越大优先级越高
        t1.getPriority();//得到线程的优先级
        t2.getPriority();
        //设置线程优先级
        t1.setPriority(10);
        t2.setPriority(1);
        /*//get 你获得线程运行之后的结果
        //如果线程还没有运行结束，那么get()方法会在这里死等
        String s = ft.get();//该方法一定只能在start()方法后调用
        System.out.println(s);*/

        //开启对象
        t1.start();
        t2.start();
    }
}
