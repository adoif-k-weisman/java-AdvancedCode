package com.ieheima.date.jdk8date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class JDK8DateDemo1 {
    public static void main(String[] args) throws ParseException {
        //JDKMethod();
        String s="2020年11月11日 00:00:00";
        DateTimeFormatter pattern=DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime localDateTime=LocalDateTime.parse(s,pattern);
        LocalDateTime newLocalDateTime = localDateTime.plusDays(1);
        String result=newLocalDateTime.format(pattern);
        System.out.println(result);

    }

    private static void JDKMethod() throws ParseException {
        String s="2020年11月11日 00:00:00";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date=sdf.parse(s);//把字符串转换成Date类对象
        long time =date.getTime();//
        time=time+(1000*60*60*24);//加上一天的毫秒
        Date newDate=new Date(time);//初始化新的日期对象
        String result=sdf.format(newDate);//转换成对应的字符串格式
        System.out.println(result);
    }
}
