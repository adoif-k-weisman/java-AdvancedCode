package com.ieheima.functionprogramming;

public class StringHandlerDemo {
    /*
        1.首先存在一个接口（StringHandler）
        2.在该接口中存在一个抽象方法（printMessage），该方法是有参数无返回值
        3.在测试类（StringHandlerDemo）中存在一个方法（useStringHandler）
                方法的的参数是StringHandler类型的
                在方法内部调用了StringHandler的printMessage方法
     */
    public static void main(String[] args) {
        useStringHandler(new StringHandler() {
            @Override
            public void printMessage(String msg) {
                System.out.println("我是匿名内部类" + msg);
            }
        });

        useStringHandler((String msg)->{
            System.out.println("我是未省略的Lambda表达式"+msg);
        });
        // Lambda实现 使用省略模式
        useStringHandler( msg -> System.out.println("我是Lambda表达式" + msg));
    }

    public static void useStringHandler(StringHandler stringHandler){
        stringHandler.printMessage("itheima");
    }



}

interface StringHandler {
    void printMessage(String msg);
}
