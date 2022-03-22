package com.ieheima.collection_list.mycollecton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MyCollectonDemo2 {
    public static void main(String[] args) {
        Collection<String> collection=new ArrayList<>();

        collection.add("aaa");
        collection.add("bbb");
        collection.add("ccc");
//        void clear()			清空集合
        //就是将集合中所有的元素全部删除.

//        boolean contains(Object o)	判断集合中是否存在指定的元素

        Collection<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        //1,获得迭代器的对象
        //迭代器对象一旦被创建出来，默认指向集合的0索引处
        Iterator<String> it=list.iterator();

        //利用迭代器里面的方法进行遍历
        //当前位置是否有元素可以被取出
        System.out.println(it.hasNext());
        //取出当前位置的元素 + 将迭代器往后移动一个索引的位置
        System.out.println(it.next());

        while(it.hasNext()){
            System.out.println(it.next());
        }

        method2(collection);
    }

    private static void method2(Collection<String> collection) {
        //        boolean removeif(Object o)	根据条件进行删除
        //removeif底层会遍历集合,得到集合中的每一个元素
        //s依次表示集合中的每一个元素
        //就会把这每一个元素都到lambda表达式中去判断一下
        //如果返回的是true,则删除
        //如果返回的是false,则保留不删除.
        collection.removeIf((String s)->{
            return s.length()==3;
        });

        System.out.println(collection);
    }
    /*
    //        boolean remove(Object o)	    从集合中移除指定的元素
        //如果删除成功了,则返回true
        //如果删除失败了,则返回false
     */

}
