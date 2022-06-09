package com.muc.threaddemo3;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"call you back"+i);
        }

        //返回值就表示线程运行完毕之后的结果
        return "OK,I will come back";
    }


}
