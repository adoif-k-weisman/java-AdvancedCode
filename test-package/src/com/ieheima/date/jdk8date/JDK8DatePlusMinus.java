package com.ieheima.date.jdk8date;

import java.time.LocalDateTime;


public class JDK8DatePlusMinus {
    public static void main(String[] args) {
        plusTime();

        minusTime();

    }

    /**
     * JDK8 时间类减少或者添加时间的方法
     */
    private static void minusTime() {
        // 与plus相反，minus 正数为减，负数为加
        //public LocalDateTime minusYears(long years) 减少或者添加年
        LocalDateTime localDateTime = LocalDateTime.of(2020, 11, 11, 13, 14, 15);
        LocalDateTime newLocalDateTime = localDateTime.minusYears(1);
        System.out.println(newLocalDateTime);
    }

    /**
     * JDK8 时间类添加或者减少时间的方法
     */
    private static void plusTime() {
        //public LocalDateTime plusYears(long years)    添加或者减去 年数  years可以为正数或者负数
        LocalDateTime localDateTime = LocalDateTime.of(2020, 11, 11, 13, 14, 15);
        LocalDateTime newLocalDateTime = localDateTime.plusYears(1);
        System.out.println(newLocalDateTime);
    }
}
