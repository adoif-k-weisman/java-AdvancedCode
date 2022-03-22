package com.ieheima.date.mydate;

import java.util.Date;
public class DateDemo1 {
    public static void main(String[] args) {
        //public Date()  创建一个Date对象，表示默认时间
        //public Date(long date) 创建一个Date对象，表示指定时间

        //那么这个时间就表示电脑中的当前时间.
        Date date1=new Date();
        System.out.println(date1);

        //从计算机的时间原点开始，过了指定毫秒的那个时间
        Date date2=new Date(0l);
        System.out.println(date2);
    }
}
