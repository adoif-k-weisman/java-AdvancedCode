package com.ieheima.test_innerclass;

public class TestSwimming {
    public static void main(String[] args) {
        goSwimming(new Swimming(){
            @Override
            public void swim() {
                System.out.println("兄弟，游泳先啦，all right!");
            }
        });

        //这里也可以省略
        goSwimming(()->{
            System.out.println("兄弟，游泳先啦，all right!");
        });
    }

/**
 * 使用接口的方法
 */
public static void goSwimming(Swimming swimming){
    swimming.swim();
}
}
/*
游泳接口
 */
interface Swimming{
    void swim();
}