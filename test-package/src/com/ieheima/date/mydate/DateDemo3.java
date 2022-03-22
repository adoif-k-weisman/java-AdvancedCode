package com.ieheima.date.mydate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo3 {
    public static void main(String[] args) {
        //当前时间的Date对象
        Date date = new Date();

        //创建了一个日期格式。
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        //将日期格式和Date对象联系起来
        String result1 = sdf.format(date);
        System.out.println(result1);

    }
}
