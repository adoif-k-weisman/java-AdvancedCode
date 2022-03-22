package com.ieheima.date.jdk8date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class JDK8DatePeriod {
    public static void main(String[] args) {
        //public static Period between(开始时间，结束时间)  计算二个“时间”的间隔

        LocalDate localDate1=LocalDate.of(2020,1,1);
        LocalDate localDate2= LocalDate.of(2048,12,12);
        Period period=Period.between(localDate1,localDate2);
        System.out.println(period);

        //public int getYears()  获得这段时间的年数
        System.out.println(period.getYears());
        //public int getMonths()  获得此期间的月数
        System.out.println(period.getMonths());
        //public int getDays() 获得此期间的天数
        System.out.println(period.getDays());

        //public long toTotalMonths()  获得此期间的总月数
        System.out.println(period.toTotalMonths());


        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 1, 1, 13, 14, 15);
        LocalDateTime localDateTime2 = LocalDateTime.of(2020, 1, 2, 11, 12, 13);
        Duration duration = Duration.between(localDateTime1, localDateTime2);
        System.out.println(duration);
        //public long toSeconds()   获得此时间间隔的秒
        System.out.println(duration.toSeconds());
        //public int toMillis()    获得此时间间隔的毫秒
        System.out.println(duration.toMillis());
        //public int toNanos()   获得此时间间隔的纳秒
        System.out.println(duration.toNanos());

    }
}
