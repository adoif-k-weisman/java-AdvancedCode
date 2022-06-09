package com.muc.threaddemo2;

import java.util.TreeMap;

public class MyRunnable implements Runnable{
    @Override
    public void run()
    {
        //表示线程启动后执行的代码
        for(int i=0;i<100;i++){

            try {
                Thread.sleep(100);//这里不能抛出异常
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //注意点：如果一个类、接口的方法中没有抛出异常，那么它的子类或者实现类重写的方法就不能抛出异常
            //必须自己try catch
            System.out.println(Thread.currentThread().getName()+"第二种方式实现多线程:"+i);
        }

    }
}
