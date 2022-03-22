package com.ieheima.functionprogramming;

import java.util.Random;

public class RandomNumHandlerDemo {
    /*
        1. 首先存在一个接口（RandomNumHandler）
        2. 在该接口中存在一个抽象方法（getNumber），该方法是无参数但是有返回值
        3. 在测试类（RandomNumHandlerDemo）中存在一个方法（useRandomNumHandler）
                方法的的参数是RandomNumHandler类型的
                在方法内部调用了RandomNumHandler的getNumber方法
     */
    public static void main(String[] args) {
        useRandomNumHandler(new RandomNumHandler() {
            @Override
            public int getNumber() {
                Random r = new Random();
                int num = r.nextInt(10) + 1;
                return num;
            }
        });

        useRandomNumHandler( () -> {
                Random r = new Random();
                int num = r.nextInt(10) + 1;
                return num;
                // 注意: 如果lambda所操作的接口中的方法, 有返回值, 一定要通过return语句, 将结果返回
                // 否则会出现编译错误
        } );
    }

    public static void useRandomNumHandler(RandomNumHandler randomNumHandler){
        int result = randomNumHandler.getNumber();
        System.out.println(result);
    }
}

interface RandomNumHandler {
    int getNumber();
}

