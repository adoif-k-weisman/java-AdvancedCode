package com.ieheima.collection_list.mycollecton;

import java.util.ArrayList;

public class MyCollectonDemo7 {
    public static void main(String[] args) {
        ArrayList<String> list =  new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");


//        for(String str : list){
//            str = "q";//修改第三方变量的值不会影响到集合中的元素 !!! 这玩意不是引用或者说指针
//            System.out.println(str);
//        }
        for (String s : list) {
            System.out.println(s);
        }
//快捷方式：容器名.for（） 便可以快速生成加强for()语句
        //list.for


        //System.out.println(list);
    }
}
