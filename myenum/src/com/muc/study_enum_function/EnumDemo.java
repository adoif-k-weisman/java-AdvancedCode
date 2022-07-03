package com.muc.study_enum_function;

public class EnumDemo {
    public static void main(String[] args) {
//        String name() 获取枚举项的名称
        String name = Season.SPRING.name();
        System.out.println(name);
        System.out.println("-----------------------------");

//        int ordinal() 返回枚举项在枚举类中的索引值
        int index1 = Season.SPRING.ordinal();
        int index2 = Season.SUMMER.ordinal();
        int index3 = Season.AUTUMN.ordinal();
        int index4 = Season.WINTER.ordinal();
        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);
        System.out.println(index4);
        System.out.println("-----------------------------");

//        int compareTo(E o) 比较两个枚举项，返回的是索引值的差值
        int result = Season.SPRING.compareTo(Season.WINTER);
        System.out.println(result);//-3
        System.out.println("-----------------------------");

//        String toString()   返回枚举常量的名称
        String s = Season.SPRING.toString();
        System.out.println(s);
        System.out.println("-----------------------------");

//        static <T> T valueOf(Class<T> type,String name)
//        获取指定枚举类中的指定名称的枚举值
        Season spring = Enum.valueOf(Season.class, "SPRING");
        System.out.println(spring);
        System.out.println(Season.SPRING == spring);
        System.out.println("-----------------------------");

//        values()       获得所有的枚举项
        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println(value);
        }


    }
}
