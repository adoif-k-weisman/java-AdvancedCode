package com.itheima.parse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //指定该注解可以使用在类上
@Retention(RetentionPolicy.RUNTIME)//指定该注解的存活时间 --- 为运行期
public @interface WebServlet {

    //让用户去指定某一个Servlet在进行访问的时候所对应的请求uri
    public String urlPatterns();
}
