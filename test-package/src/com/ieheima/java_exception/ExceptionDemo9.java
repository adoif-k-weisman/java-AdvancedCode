package com.ieheima.java_exception;



public class ExceptionDemo9 {
    public static void main(String[] args) {

        //好处:为了能让代码继续往下运行.
        int [] arr = null;
        try{
            //有肯能发现异常的代码
            printArr(arr);
        }catch (NullPointerException e){
            //如果出现了这样的异常,那么我们进行的操作
            System.out.println("参数不能为null");
        }


        System.out.println("嘿嘿嘿,我最帅!!!");

    }

    private static void printArr(int[] arr) {
        if(arr == null){
            throw new NullPointerException();
        }else{
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }
    }
}
