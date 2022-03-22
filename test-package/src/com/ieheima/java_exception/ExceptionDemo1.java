package com.ieheima.java_exception;

public class ExceptionDemo1 {
        public static void main(String[] args)  {
//思考:控制台为什么会有这样的红色字体呢? 是谁打印的?
            int [] arr = {1,2,3,4,5};
            System.out.println(arr[10]);//当代码出现了异常,那么就在这里创建了一个异常对象.
            //new ArrayIndexOutOfBoundsException();
            //首先会看,程序中有没有自己处理异常的代码.
            //如果没有,交给本方法的调用者处理.
            //最终这个异常会交给虚拟机默认处理.
            //JVM默认处理异常做了哪几件事情:
            //1,将异常信息以红色字体展示在控制台上.
            //2,停止程序运行. --- 哪里出现了异常,那么程序就在哪里停止,下面的代码不执行了.
            System.out.println("嘿嘿嘿,我最帅");
        }
}
