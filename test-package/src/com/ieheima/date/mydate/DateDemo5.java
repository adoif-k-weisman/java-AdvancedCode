package com.ieheima.date.mydate;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateDemo5 {
    public static void main(String[] args) throws ParseException {
        //开始时间： 2020年11月11日 0:0:0
        //结束时间： 2020年11月11日 0:10:0

        //小贾：2020年11月11日 0:03:47
        //小皮：2020年11月11日 0:10:11

        //1.判断二位同学的下单时间是否在范围之内就可以了
        //2.要把每一个时间都换算成毫秒值

        String start="2020年11月11日 0:0:0";
        String end="2020年11月11日 0:10:0";

        String jia="2020年11月11日 0:03:47";
        String pi="2020年11月11日 0:10:11";

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        long startTime = sdf.parse(start).getTime();
        long endTime=sdf.parse(end).getTime();

        System.out.println(startTime);
        System.out.println(endTime);
        long jiaTime = sdf.parse(jia).getTime();
        long piTime =sdf.parse(pi).getTime();
        //判断
        if(jiaTime>=startTime && jiaTime <= endTime){
            System.out.println("小贾同学参加上了秒杀活动");
        }else{
            System.out.println("小贾同学没有参加上秒杀活动");
        }

        System.out.println("----------------------------");

        if(piTime>=startTime && piTime <= endTime){
            System.out.println("小皮同学参加上了秒杀活动");
        }else{
            System.out.println("小皮同学没有参加上秒杀活动");
        }
    }
}
