package com.muc.daemonthread;

public class MyThread2 extends Thread {
    @Override
    public void  run(){
        //这部分代码就是线程在开启之后执行的代码
       /* for(int i=0;i<100;i++){
            System.out.println("线程开启了"+i);
        }*/

        for(int i=0;i<100;i++)
        {
            System.out.println(getName()+"@@@"+i);
        }

    }

}
