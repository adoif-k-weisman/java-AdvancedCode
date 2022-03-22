package com.ieheima.functionprogramming;

public class TestLambda {
    /*
    Lambda表达式的使用前提：
        1.一个接口
        2.接口中有且仅有一个抽象方法
       练习1：
        1.编写一个接口
        2. 在该接口中存在一个抽象方法（show），该方法是无参数无返回值
        3. 在测试类（ShowHandlerDemo）中存在一个方法（useShowHandler）
                        方法的的参数是ShowHandler类型的
                        在方法内部调用了ShowHandler的show方法
     */
    public static void main(String[] args) {
        useShowHandler(new ShowHandler() {
            @Override
            public void show() {
                System.out.println("我是匿名内部类中的show方法");
            }
        });
        //不省略模式：
        useShowHandler(()->{
            System.out.println("我是lambda没有省略的方法");
        });

        // Lambda实现 同样地，这也是省略过后的， 大括号，分号；
        useShowHandler( () -> System.out.println("我是Lambda中的show方法"));
    }

    public static void useShowHandler(ShowHandler showHandler){
        showHandler.show();
    }
}

interface ShowHandler {
    void show();
}
