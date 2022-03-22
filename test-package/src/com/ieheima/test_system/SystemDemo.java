package com.ieheima.test_system;

public class SystemDemo {
    public static void main(String[] args) {
//        public static void exit(int status)	终止当前运行的 Java 虚拟机，非零表示异常终止
//        System.out.println(111);
//        //while(true){}
//        System.exit(0);  //当代码执行到这个方法的时候,就表示虚拟机已经停止了
//        System.out.println(2222);


//        public static long currentTimeMillis()  返回当前时间(以毫秒为单位)
//        long start = System.currentTimeMillis();//获取当前时间
//        //System.out.println(l);
//        for (int i = 0; i < 10000; i++) {
//            System.out.println(i);
//        }
//        long end = System.currentTimeMillis();//获取当前时间
//        System.out.println(end - start);//472 --- 得到的就是这个for循环运行的时间.



//        arraycopy(数据源数组, 起始索引, 目的地数组, 起始索引, 拷贝个数)	数组copy
        int [] arr1 = {1,2,3,4,5};
        int [] arr2 = new int[10];
        //需求:我要把arr1中的数据拷贝到arr2中.
        //System.arraycopy(arr1,0,arr2,0,arr1.length);

        /*for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }*/

        //我要把arr1最后两个元素,拷贝到arr2的最后两个索引上
        System.arraycopy(arr1,3,arr2,8,2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}
