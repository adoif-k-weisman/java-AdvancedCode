package com.ieheima.date.jdk8date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class JDK8DateDemo2 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();//获取当前时间
        System.out.println(now);

        LocalDateTime localDateTime=LocalDateTime.of(2020,11,11,00,04);
        System.out.println(localDateTime);

        int year=localDateTime.getYear();
        System.out.println("为"+year);
        int month=localDateTime.getMonthValue();
        System.out.println("为"+month);

        int dayOfMonth = localDateTime.getDayOfMonth();
        System.out.println("日期为"+dayOfMonth);

        int dayofYear=localDateTime.getDayOfYear();
        System.out.println("这是一年中的第"+dayofYear+"天");

        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        System.out.println("星期为:"+dayOfWeek);

        //转换成LocalDate对象 这样就只显示年月日
        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);
    //转换成一个LocalTime对象  这样就只显示小时、分、秒
        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println(localTime);

        method1();

        //解析：把一个日期字符串解析成为一个DateLocal对象
        String s="2020年11月12日 13:14:15";
        DateTimeFormatter pattern=DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime parse=LocalDateTime.parse(s,pattern);
        System.out.println(parse);

    }

    private static void method1() {

        LocalDateTime localDateTime=LocalDateTime.of(2020,11,11,00,04);

        //把默认格式转换成指定的格式
        System.out.println(localDateTime);
        //public String format(指定格式)  把一个LocalDateTime 格式化成为一个字符串
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String format= localDateTime.format(dateTimeFormatter);
        System.out.println(format);
    }

}
