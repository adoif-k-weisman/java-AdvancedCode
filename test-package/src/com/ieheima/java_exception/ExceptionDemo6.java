package com.ieheima.java_exception;


import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionDemo6 {
    public static void main(String[] args) throws ParseException {
        method1(); //此时调用者也没有处理.还是会交给虚拟机处理.
        method2(); //还是继续交给调用者处理.而main方法的调用者是虚拟机还是会采取虚拟机默认处理异常的方法.
    }

    //告诉调用者,你调用我,有可能会出现这样的异常哦.
    //如果方法中没有出现异常,那么正常执行
    //如果方法中真的出现了异常,其实也是将这个异常交给了调用者处理.
    //如果声明的异常是一个运行时异常,那么声明的代码可以省略
    private static void method1() /*throws NullPointerException*/ {
        int [] arr = null;
        for (int i = 0; i < arr.length; i++) {//出现的空指针异常,还是由虚拟机创建出来的.
            System.out.println(arr[i]);
        }
    }

    //告诉调用者,你调用我,有可能会出现这样的异常哦.
    //如果方法中没有出现异常,那么正常执行
    //如果方法中真的出现了异常,其实也是将这个异常交给了调用者处理.
    //如果声明的异常是一个编译时异常,那么声明的代码必须要手动写出.
    private static void method2() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        sdf.parse("2048-10月10日");
    }
}
