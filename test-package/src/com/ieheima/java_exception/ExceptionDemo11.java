package com.ieheima.java_exception;

//这几种方法挺好的
public class ExceptionDemo11 {
    //public String getMessage​()    返回此 throwable 的详细消息字符串
    //public String toString​()      返回此可抛出的简短描述
    //public void printStackTrace​() 把异常的错误信息输出在控制台(字体为红色的)
    public static void main(String[] args) {

        try {
            int [] arr = {1,2,3,4,5};
            System.out.println(arr[10]);//虚拟机帮我们创建了一个异常对象 new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            /*String message = e.getMessage();
            System.out.println(message);*/
           /* String s = e.toString();
            System.out.println(s);*/
           e.printStackTrace();
        }

        System.out.println("嘿嘿嘿");

    }
}
