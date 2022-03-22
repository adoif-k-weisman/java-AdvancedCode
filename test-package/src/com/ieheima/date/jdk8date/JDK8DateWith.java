package com.ieheima.date.jdk8date;

import java.time.LocalDateTime;

/**
 * JDK8 时间类修改时间
 */
public class JDK8DateWith {

    public static void main(String[] args) {
        //public LocalDateTime withYear(int year)   修改年
        LocalDateTime localDateTime = LocalDateTime.of(2020, 11, 11, 13, 14, 15);
        LocalDateTime newLocalDateTime = localDateTime.withYear(2048);//修改年份
        System.out.println(newLocalDateTime);

        LocalDateTime newlocalDateTime1 = localDateTime.withMonth(20);//会报错，这个对month取值是有限制的，1~~12
        System.out.println(newlocalDateTime1);

    }
}
