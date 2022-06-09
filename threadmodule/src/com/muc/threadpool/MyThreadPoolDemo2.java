package com.muc.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//创建线程池对象
public class MyThreadPoolDemo2 {
    //    参数一：核心线程数量   --- 正式员工数
//    参数二：最大线程数    --- 总的员工数   总的员工数一定要大于正式员工数
//    参数三：空闲线程最大存活时间
//    参数四：时间单位  TimeUnit ，枚举类型，时间常量
//    参数五：任务队列  --- 让任务在队列中等着，等有线程空闲了，再从这个队列中获取任务并执行
//    参数六：创建线程工厂  --- 按照默认的方式创建线程对象
//    参数七：任务的拒绝策略 --- 1. 什么时候拒绝任务
                           // --- 2.  如何拒绝任务
    public static void main(String[] args) {
        //method1();//第一种拒绝策略
        //method2(); //第二种拒绝策略
        //method3();//第三种拒绝策略

//        method4();//第四种拒绝策略

    }

    private static void method4() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,
                2,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());  //该任务拒绝策略，调用任务的run方法直接执行

//        pool.submit(new MyRunnable());
//        pool.submit(new MyRunnable());


        //16  > 最大线程数 + 任务队列容量
        for(int i=1;i<=10;i++){
            int y = i;
            pool.submit(()->{
                System.out.println(Thread.currentThread().getName()+ " --- "+ y );
            });
        }

        pool.shutdown();
    }

    private static void method3() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,
                2,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());  //该任务拒绝策略，抛弃队列中等待最久的任务 然后把当前任务加入队列中

//        pool.submit(new MyRunnable());
//        pool.submit(new MyRunnable());


        //16  > 最大线程数 + 任务队列容量
        for(int i=1;i<=10;i++){
            int y = i;
            pool.submit(()->{
                System.out.println(Thread.currentThread().getName()+ " --- "+ y );
            });
        }

        pool.shutdown();
    }

    private static void method2() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,
                2,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());  //该任务拒绝策略，丢弃任务 不抛出异常

//        pool.submit(new MyRunnable());
//        pool.submit(new MyRunnable());


        //16  > 最大线程数 + 任务队列容量
        for(int i=1;i<=5;i++){
            int y = i;
            pool.submit(()->{
                System.out.println(Thread.currentThread().getName()+ " --- "+ y );
            });
        }

        pool.shutdown();
    }

    private static void method1() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,
                5,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());  //该任务拒绝策略，丢弃任务 并抛出异常

//        pool.submit(new MyRunnable());
//        pool.submit(new MyRunnable());


        //16  > 最大线程数 + 任务队列容量
        for(int i=1;i<=16;i++){
            pool.submit(new MyRunnable());
        }

        pool.shutdown();
    }
}
