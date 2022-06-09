package com.muc.threaddemo;

public class MyThread extends Thread{

    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

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
