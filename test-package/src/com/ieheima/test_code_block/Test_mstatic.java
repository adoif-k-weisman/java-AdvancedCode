package com.ieheima.test_code_block;
/*
    静态代码块：
    位置：类中方法外定义
    特点：需要通过static关键字修饰，随着类的加载而加载，并且只执行一次
    作用：在类加载的时候做一些数据初始化的操作
 */
public class Test_mstatic {
    public static void main(String[] args) {

    }
}
class Person{
    static {
        System.out.println("我是静态代码块，我执行了");
    }
    public Person(){
        System.out.println("我是Person类的空参数构造方法");
    }
    public Person(int a){
        System.out.println("我是Person类的带。。。。。参数构造方法");
    }

}
