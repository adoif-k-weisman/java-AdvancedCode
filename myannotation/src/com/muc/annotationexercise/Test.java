package com.muc.annotationexercise;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//元注解: 就是描述注解的注解  该注解表示Test这个注解的存活时间
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Test {
}
