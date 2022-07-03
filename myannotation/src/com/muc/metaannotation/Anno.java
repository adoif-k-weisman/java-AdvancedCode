package com.muc.metaannotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})  //指定注解使用的位置（成员变量，类，方法）
@Retention(RetentionPolicy.RUNTIME) //指定该注解的存活时间
    // 如果不指定的话，表示只存活在java文件里，当java文件被编译成class文件时就不存活了
//@Inherited //指定该注解可以被继承
public @interface Anno {
}
